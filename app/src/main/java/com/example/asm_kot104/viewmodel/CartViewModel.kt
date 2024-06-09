package com.example.asm_kot104.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asm_kot104.model.Cart
import com.example.asm_kot104.service.ApiService
import kotlinx.coroutines.launch
import retrofit2.await
import java.lang.Exception

class CartViewModel : ViewModel() {
    private val apiService = ApiService.apiService

    private val _carts = mutableStateOf<List<Cart>>(emptyList())
    val carts: State<List<Cart>> = _carts

    init {
        getCarts()
    }

    private fun getCarts() {
        viewModelScope.launch {
            try {
                val response = apiService.getCarts()?.await()
                _carts.value = response?.filterNotNull() ?: emptyList()
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }

    fun addCart(cart: Cart) {
        viewModelScope.launch {
            try {
                val response = apiService.addCart(cart)?.await()
                response?.let {
                    // Optionally update local state or perform other actions
                    getCarts() // Refresh the list after adding a cart
                }
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }

    fun updateCart(cart: Cart, id: String) {
        viewModelScope.launch {
            try {
                val response = apiService.updateCart(cart, id)?.await()
                response?.let {
                    // Optionally update local state or perform other actions
                    getCarts() // Refresh the list after updating a cart
                }
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }

    fun deleteCart(id: String) {
        viewModelScope.launch {
            try {
                val response = apiService.deleteCart(id)?.await()
                response?.let {
                    // Optionally update local state or perform other actions
                    getCarts() // Refresh the list after deleting a cart
                }
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }
}
