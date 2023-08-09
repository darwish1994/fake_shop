package com.example.fakestore.feature.main.products.data.repo

import com.example.fakestore.core.network.NetworkRemoteServiceCall
import com.example.fakestore.core.network.Resource
import com.example.fakestore.feature.main.products.data.remote.api.ProductsApi
import com.example.fakestore.feature.main.products.data.util.toProduct
import com.example.fakestore.feature.main.products.domain.model.Product
import com.example.fakestore.feature.main.products.domain.repo.ProductsRepo
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(private val productsApi: ProductsApi) : ProductsRepo,
    NetworkRemoteServiceCall {
    override suspend fun getProductsByCategory(category: String): Resource<List<Product>> =
        safeApiCallGeneric {
            productsApi.getCategoryProducts(category).map { it.toProduct() }
        }

    override suspend fun getAllProducts(): Resource<List<Product>>  =
        safeApiCallGeneric {
            productsApi.getAllProducts().map { it.toProduct() }
        }

}