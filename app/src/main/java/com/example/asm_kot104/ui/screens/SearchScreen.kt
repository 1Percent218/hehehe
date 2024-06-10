package com.example.asm_kot104.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.asm_kot104.model.Cart
import com.example.asm_kot104.model.Category
import com.example.asm_kot104.model.Product
import com.example.asm_kot104.model.Screen
import com.example.asm_kot104.ui.components.EditText
import com.example.asm_kot104.ui.components.ItemHome
import com.example.asm_kot104.viewmodel.CartViewModel
import com.example.asm_kot104.viewmodel.MainViewModel
import com.example.asm_kot104.viewmodel.ProductViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    mainViewModel: MainViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel()
) {
    val list by mainViewModel.products

    var textSearch by remember {
        mutableStateOf("")
    }

    Column {
        TextField(
            value = textSearch,
            onValueChange = {
                textSearch = it
                mainViewModel.search(textSearch)
            },
            placeholder = { Text(text = "enter your keyword") },
            modifier = Modifier.fillMaxWidth()
        )
        LazyColumn(
            Modifier.padding(10.dp)
        ) {
            items(list) { item ->
                ItemHome(item, addToCart = {
                    cartViewModel.addCart(
                        Cart(
                            idProduct = item,
                            quantity = 1,
                            idAccount = "123"
                        )
                    )
                }, onClick = {
                    navController.navigate(Screen.VIEW_DETAIL_SCREEN.name)
                })
            }
        }
    }
}