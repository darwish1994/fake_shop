package com.example.fakestore.feature.main.category.domain.repo

import com.example.fakestore.core.network.Resource

interface CategoryRepo {

    suspend fun getCategories():Resource<List<String>>

}