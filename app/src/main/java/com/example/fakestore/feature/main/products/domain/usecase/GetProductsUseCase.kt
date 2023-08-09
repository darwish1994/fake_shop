package com.example.fakestore.feature.main.products.domain.usecase

import com.example.fakestore.core.network.Resource
import com.example.fakestore.feature.main.products.domain.repo.ProductsRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val productsRepo: ProductsRepo) {
    operator fun invoke() = flow {
        emit(Resource.Loading())
        emit(productsRepo.getAllProducts())
    }
}