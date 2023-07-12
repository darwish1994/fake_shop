package com.example.fakestore.feature.auth.domain.repo

import com.example.fakestore.core.network.UserUrl
import retrofit2.http.POST

interface AuthRepo {

    @POST(UserUrl.register)
    suspend fun createAccount()
}