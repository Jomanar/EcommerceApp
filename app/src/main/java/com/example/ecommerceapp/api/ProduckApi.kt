package com.example.ecommerceapp.api

import com.example.ecommerceapp.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {
    @GET("/b/MX0A")
    fun getProducts(): Call<List<Product>>
}