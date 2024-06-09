package com.example.asm_kot104.service

import com.example.asm_kot104.model.Account
import com.example.asm_kot104.model.Bill
import com.example.asm_kot104.model.BillDetails
import com.example.asm_kot104.model.Page
import com.example.asm_kot104.model.Cart
import com.example.asm_kot104.model.Category
import com.example.asm_kot104.model.Product
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ApiService {
    @POST("register")
    fun register(@Body account: Account?): Call<Account?>?

    @POST("login")
    fun login(@Body account: Account?): Call<Account?>?

    @get:GET("categories")
    val categories: Call<List<Category?>?>?

    @GET("products/category/{id}")
    fun getProductByCategory(@Path("id") id: String?): Call<List<Product?>?>?

    @get:GET("products")
    val products: Call<List<Product?>?>?

    @GET("products/{id}")
    fun getProductById(@Path("id") id: String?): Call<Product?>?

    @GET("get-page-products")
    fun getPageProducts(@QueryMap options: Map<String?, String?>?): Call<Page<List<Product?>?>?>?

    @POST("carts")
    fun addCart(@Body cart: Cart?): Call<Cart?>?

    @PUT("carts/{id}")
    fun updateCart(@Body cart: Cart?, @Path("id") id: String?): Call<Cart?>?

    @DELETE("carts/{id}")
    fun deleteCart(@Path("id") id: String?): Call<Cart?>?

    @GET("carts")
    fun getCarts(): Call<List<Cart?>?>?

    @PUT("accounts/{id}")
    fun updateAccount(@Body account: Account?, @Path("id") id: String?): Call<Account?>?

    @POST("bills")
    fun createBill(@Body bill: Bill?): Call<Bill?>?

    @get:GET("bills")
    val bills: Call<List<Any?>?>?

    @POST("billdetails")
    fun createBillDetails(@Body billDetails: BillDetails?): Call<BillDetails?>?

    @GET("billdetails/{id}")
    fun getBillDetails(@Path("id") id: String?): Call<List<BillDetails?>?>?

    companion object {
        const val BASE_URL: String = "http://192.168.1.102:3000/api/"
        val apiService: ApiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}