package com.example.fakestore.core.network

object UserUrl{
    const val register="users"
    const val login ="auth/login"


}

object ProductUrl{
    const val allProduct="products"
    const val product="products/{id}"
    const val productsByCategory ="products/category/{category}"
}

object CategoryUrl{
    const val categories="categories"
}

object CartUrl{
    const val cart="carts/user/{id}"
    const val addToCart="carts"
    const val updateCart="carts/{id}"
    const val deleteCart="carts/{id}"
}