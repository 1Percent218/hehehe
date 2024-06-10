package com.example.asm_kot104.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asm_kot104.model.Product
import com.example.asm_kot104.service.ApiService
import kotlinx.coroutines.launch
import retrofit2.await

class ProductViewModel : ViewModel() {
    private val apiService = ApiService.apiService
    private val _product = mutableStateOf<Product?>(null)
    val product: State<Product?> = _product

    fun getProductById(id: String) {
        viewModelScope.launch{
            try {
                val response = apiService.getProductById(id)?.await()
                _product.value = response
            }catch (e: Exception){
                Log.d("ProductViewModel", "getProductById: $e")
            }
        }
    }
}