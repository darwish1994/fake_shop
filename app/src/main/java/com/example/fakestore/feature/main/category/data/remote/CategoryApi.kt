package com.example.fakestore.feature.main.category.data.remote

import com.example.fakestore.core.network.CategoryUrl
import retrofit2.http.GET

interface CategoryApi {

    @GET(CategoryUrl.categories)
    suspend fun getAllCategory() : List<String>



}