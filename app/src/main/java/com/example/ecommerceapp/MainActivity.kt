package com.example.ecommerceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ecommerceapp.api.RetrofitInstance
import com.example.ecommerceapp.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Llamar a la API y obtener los productos
        getProducts()
    }

    private fun getProducts() {
        val call = RetrofitInstance.api.getProducts()
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    products?.let {
                        for (product in it) {
                            Log.d("MainActivity", "Product: $product")
                        }
                    }
                } else {
                    Log.e("MainActivity", "Failed to get products")
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.e("MainActivity", "Error: ${t.message}")
            }
        })
    }
}