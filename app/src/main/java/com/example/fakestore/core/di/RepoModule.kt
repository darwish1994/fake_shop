package com.example.fakestore.core.di

import com.example.fakestore.feature.main.category.data.remote.CategoryApi
import com.example.fakestore.feature.main.category.data.repo.CategoryRepoImpl
import com.example.fakestore.feature.main.category.domain.repo.CategoryRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepoModule {

    @Provides
    @Singleton
    fun provideCategoryRepo(categoryApi: CategoryApi): CategoryRepo = CategoryRepoImpl(categoryApi)
}