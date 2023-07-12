package com.example.fakestore.feature.auth.domain.model


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("firstname")
    val firstname: String?,
    @SerializedName("lastname")
    val lastname: String?
)