package com.example.fakestore.feature.main.category.data.repo

import com.example.fakestore.core.network.NetworkRemoteServiceCall
import com.example.fakestore.core.network.Resource
import com.example.fakestore.feature.main.category.data.remote.CategoryApi
import com.example.fakestore.feature.main.category.domain.repo.CategoryRepo
import javax.inject.Inject

class CategoryRepoImpl @Inject constructor(private val categoryApi: CategoryApi) : CategoryRepo,
    NetworkRemoteServiceCall {
    override suspend fun getCategories(): Resource<List<String>> = safeApiCallGeneric {
        categoryApi.getAllCategory()
    }
}