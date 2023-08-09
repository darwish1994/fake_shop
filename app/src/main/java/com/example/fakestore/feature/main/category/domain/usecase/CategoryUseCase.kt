package com.example.fakestore.feature.main.category.domain.usecase

import com.example.fakestore.core.network.Resource
import com.example.fakestore.feature.main.category.domain.repo.CategoryRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryUseCase @Inject constructor(private val categoryRepo: CategoryRepo) {
    operator fun invoke() = flow {
        emit(Resource.Loading())
        emit(categoryRepo.getCategories())
    }
}