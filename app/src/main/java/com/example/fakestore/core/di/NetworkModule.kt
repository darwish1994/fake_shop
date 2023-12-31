package com.example.fakestore.core.di

import android.content.Context
import com.example.fakestore.BuildConfig
import com.example.fakestore.core.Constant
import com.example.fakestore.core.network.NetworkHelper
import com.example.fakestore.core.network.NetworkInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient, gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()


    @Provides
    @Singleton
    fun provideOKHTTPInstance(
        networkInterceptor: NetworkInterceptor,
        loggerNetworkInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val httpClient = OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(networkInterceptor)
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(loggerNetworkInterceptor)
        }

        return httpClient.build()
    }


    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder()
        .setDateFormat(Constant.timeFormat)
        .create()

    @Provides
    @Singleton
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper =
        NetworkHelper(context)

    @Provides
    @Singleton
    fun provideNetworkInterceptor(networkHelper: NetworkHelper): NetworkInterceptor =
        NetworkInterceptor(networkHelper)

    @Provides
    @Singleton
    fun provideLoggerInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


}