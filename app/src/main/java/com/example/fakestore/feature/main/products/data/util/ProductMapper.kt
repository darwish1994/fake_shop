package com.example.fakestore.feature.main.products.data.util

import com.example.fakestore.feature.main.products.data.model.ProductDto
import com.example.fakestore.feature.main.products.domain.model.Product

fun ProductDto.toProduct() = Product(
    id = id,
    title = title,
    price = price,
    category = category,
    description = description,
    image = image
)

fun Product.toProduct() = ProductDto(
    id = id,
    title = title,
    price = price,
    category = category,
    description = description,
    image = image
)