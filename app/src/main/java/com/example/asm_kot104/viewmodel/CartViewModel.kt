package com.example.asm_kot104.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asm_kot104.model.Bill
import com.example.asm_kot104.model.BillDetails
import com.example.asm_kot104.model.Cart
import com.example.asm_kot104.service.ApiService
import kotlinx.coroutines.launch
import retrofit2.await
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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

    fun getTotalPrice():Int{
        var total = 0
        for (i in carts.value){
            total += i.idProduct!!.price * i.quantity
        }
        return total
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun buyNow(){
        viewModelScope.launch {
            try {
                val current = LocalDateTime.now()

                // Định dạng thời gian
                val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                val formatted = current.format(formatter)
                val response = apiService.createBill(Bill(null,
                    formatted,
                    getTotalPrice().toString(), carts.value.size.toString(), null))?.await()


                for (i in carts.value){
                    if (response != null) {
                        apiService.createBillDetails(BillDetails(
                            _id = null,
                            billId = response.get_id(),
                            productId = i.idProduct,
                            quantity = i.quantity
                        ))?.await()
                    }
                }
                for (i in carts.value){
                    deleteCart(i._id!!)
                }
            }catch (e: Exception){
                Log.d("CartViewModel", "buyNow: $e")
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
