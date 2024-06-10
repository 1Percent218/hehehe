package com.example.asm_kot104.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asm_kot104.model.Bill
import com.example.asm_kot104.service.ApiService
import kotlinx.coroutines.launch
import retrofit2.await

class BillViewModel : ViewModel() {
    private val apiService = ApiService.apiService
    private val _bills = mutableStateOf<List<Bill>>(emptyList())
    val bills: State<List<Bill>> = _bills

    init {
        getAllBill()
    }

    fun getAllBill() {
        viewModelScope.launch {
            try {
                val response = apiService.bills?.await()
                _bills.value = response?.reversed() ?: emptyList()
            } catch (e: Exception) {
                Log.d("BillViewModel", "getAllBill: $e")
            }
        }
    }
}