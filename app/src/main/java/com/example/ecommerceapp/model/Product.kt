package com.example.ecommerceapp.model

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val currency: String,
    val instock: Boolean
)