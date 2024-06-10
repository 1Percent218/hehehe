package com.example.asm_kot104.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asm_kot104.model.Bill
import com.example.asm_kot104.model.BillDetails
import com.example.asm_kot104.service.ApiService
import kotlinx.coroutines.launch
import retrofit2.await

class BillDetailsViewModel : ViewModel() {
    private val apiService = ApiService.apiService
    private val _billDetails = mutableStateOf<List<BillDetails>>(emptyList())
    val billDetails: State<List<BillDetails>> = _billDetails

    fun getAllBillDetails(id: String) {
        viewModelScope.launch {
            try {
                val response = apiService.getBillDetails(id)?.await()
                _billDetails.value = (response?.reversed() ?: emptyList()) as List<BillDetails>
            } catch (e: Exception) {
                Log.d("BillViewModel", "getAllBill: $e")
            }
        }
    }
}