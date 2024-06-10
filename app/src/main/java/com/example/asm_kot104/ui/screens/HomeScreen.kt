package com.example.asm_kot104.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.asm_kot104.R
import com.example.asm_kot104.model.Cart
import com.example.asm_kot104.model.Category
import com.example.asm_kot104.model.Product
import com.example.asm_kot104.model.Screen
import com.example.asm_kot104.ui.components.HeaderApp
import com.example.asm_kot104.ui.components.ItemHome
import com.example.asm_kot104.ui.components.MIcon
import com.example.asm_kot104.ui.theme.ASM_KOT104Theme
import com.example.asm_kot104.viewmodel.CartViewModel
import com.example.asm_kot104.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel()
) {
    val list by viewModel.products
    val listCategory by viewModel.categories
    var categorySelected by remember {
        mutableStateOf(Category("all", "all"))
    }
    viewModel.getProductsByCategory(categorySelected._id!!)
    val listIconId =
        intArrayOf(R.drawable.grid, R.drawable.vegetable, R.drawable.fruits, R.drawable.drink)

    Column {
        HeaderApp(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.LightGray
                    )
                ) {
                    append("Healthy")
                }
                withStyle(
                    SpanStyle(
                        color = Color.Black,
                    )
                ) {
                    append("\nSTORE")
                }
            },
            iconLeft = Icons.Default.Search,
            iconRight = Icons.Default.ShoppingCart,
            iconLeftOnClick = {
                navController.navigate(Screen.SEARCH_SCREEN.name)
            },
            iconRightOnClick = {
                navController.navigate(Screen.CART_SCREEN.name)
            },
        )
        ListIcon(listIconId) {
            if (it == -1) {
                categorySelected = Category("all", "all")
                return@ListIcon
            }
            categorySelected = listCategory[it]
        }
        LazyColumn(
            Modifier.padding(10.dp)
        ) {
            items(list) { item ->
                ItemHome(item, addToCart = {
                    cartViewModel.addCart(Cart(
                        idProduct = item,
                        quantity = 1,
                        idAccount = "123"
                    ))
                }, onClick = {
                    navController.navigate("${Screen.VIEW_DETAIL_SCREEN.name}/${item._id}")
                })
            }
        }
    }
}

@Composable
fun ListIcon(listIconId: IntArray, onClick: (Int) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        for (i in 0 until listIconId.size) {
            MIcon(iconId = listIconId[i]) {
                onClick(i - 1)
            }
        }
    }
}