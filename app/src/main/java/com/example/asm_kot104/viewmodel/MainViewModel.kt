package com.example.asm_kot104.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asm_kot104.model.Product
import com.example.asm_kot104.service.ApiService
import androidx.compose.runtime.*
import com.example.asm_kot104.model.Category
import kotlinx.coroutines.launch
import retrofit2.await

class MainViewModel : ViewModel() {
    private val apiService = ApiService.apiService

    private val _products = mutableStateOf<List<Product>>(emptyList())
    val products: State<List<Product>> = _products

    private val _categories = mutableStateOf<List<Category>>(emptyList())
    val categories: State<List<Category>> = _categories

    init {
        getProductsByCategory("all")
        getCategories()
    }

    fun getProductsByCategory(categoryId: String) {
        viewModelScope.launch {
            try {
                val response = apiService.getProductByCategory(categoryId)?.await()
                _products.value = response?.filterNotNull() ?: emptyList()
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }

    fun search (string: String){
        viewModelScope.launch {
            try {
                val response = apiService.productsSearch(string)?.await()
                _products.value = response?.filterNotNull() ?: emptyList()
            }catch (e:Exception){
                Log.d("MainViewModel", "search: $e")
            }
        }
    }

    private fun getCategories() {
        viewModelScope.launch {
            try {
                val response = apiService.categories?.await()
                _categories.value = response?.filterNotNull() ?: emptyList()
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }
}
