package com.example.fakestore.feature.main.products.domain.usecase

import com.example.fakestore.core.network.Resource
import com.example.fakestore.feature.main.products.domain.repo.ProductsRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCategoryProductsUseCase @Inject constructor(private val productsRepo: ProductsRepo) {
    operator fun invoke(category:String) = flow {
        emit(Resource.Loading())
        emit(productsRepo.getProductsByCategory(category))
    }
}