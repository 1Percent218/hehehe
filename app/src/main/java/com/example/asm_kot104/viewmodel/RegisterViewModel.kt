package com.example.asm_kot104.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asm_kot104.model.Account
import com.example.asm_kot104.service.ApiService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {
    val registerResult = MutableLiveData<Account?>()
    val errorMessage = MutableLiveData<String?>()

    fun register(account: Account) {
        viewModelScope.launch {
            val call = ApiService.apiService.register(account)
            call?.enqueue(object : Callback<Account?> {
                override fun onResponse(call: Call<Account?>, response: Response<Account?>) {
                    if (response.isSuccessful) {
                        registerResult.postValue(response.body())
                    } else {
                        errorMessage.postValue("Registration failed: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<Account?>, t: Throwable) {
                    errorMessage.postValue("Registration failed: ${t.message}")
                }
            })
        }
    }
}
