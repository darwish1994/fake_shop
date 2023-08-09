package com.example.fakestore.feature.main.category

data class CategoryState(
    val categories: List<String>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
