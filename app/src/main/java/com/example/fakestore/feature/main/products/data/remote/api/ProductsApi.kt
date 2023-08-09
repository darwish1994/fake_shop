package com.example.fakestore.feature.main.products.data.remote.api

import com.example.fakestore.core.network.ProductsUrl
import com.example.fakestore.feature.main.products.data.model.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductsApi {

    @GET(ProductsUrl.allProduct)
    suspend fun getAllProducts():List<ProductDto>

    @GET(ProductsUrl.productsByCategory)
    suspend fun getCategoryProducts(@Path("category") category:String):List<ProductDto>
}