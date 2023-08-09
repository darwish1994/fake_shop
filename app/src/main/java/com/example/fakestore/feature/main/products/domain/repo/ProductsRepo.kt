package com.example.fakestore.feature.main.products.domain.repo

import com.example.fakestore.core.network.Resource
import com.example.fakestore.feature.main.products.domain.model.Product

interface ProductsRepo {
    suspend fun getProductsByCategory(category: String): Resource<List<Product>>
    suspend fun getAllProducts(): Resource<List<Product>>


}