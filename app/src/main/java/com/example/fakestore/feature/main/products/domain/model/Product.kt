package com.example.fakestore.feature.main.products.domain.model

import com.google.gson.annotations.SerializedName

data class Product(
    val category: String?,
    val description: String?,
    val id: Int?,
    val image: String?,
    val price: String?,
    val title: String?
)
