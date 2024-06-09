package com.example.asm_kot104.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.asm_kot104.model.Cart
import com.example.asm_kot104.model.Category
import com.example.asm_kot104.model.Product
import com.example.asm_kot104.ui.components.ButtonFilled
import com.example.asm_kot104.ui.components.CartItem
import com.example.asm_kot104.ui.components.HeaderApp
import com.example.asm_kot104.viewmodel.CartViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CartScreen(navController: NavController, viewModel: CartViewModel = viewModel()) {
    val list by viewModel.carts
    Log.d("TAG", "CartScreen: ${list.size}")
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (headerRef, listRef, bottomRef) = createRefs()
        HeaderApp(
            text = buildAnnotatedString { append("Card") },
            iconLeft = Icons.Default.ArrowBack,
            iconRight = null,
            iconLeftOnClick = {
                navController.popBackStack()
            },
            iconRightOnClick = {
            },
            modifier = Modifier.constrainAs(headerRef) {
                top.linkTo(parent.top)
            })

        LazyColumn(modifier = Modifier
            .constrainAs(listRef) {
                top.linkTo(headerRef.bottom)
            }
            .fillMaxSize()) {
            items(list) { item ->
                CartItem(item = item)
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(bottomRef) {
                    bottom.linkTo(parent.bottom)
                }
                .padding(10.dp, 0.dp)
        ) {
            Text(text = "Tổng tiền: 1000000000 VND")
            ButtonFilled(text = "Buy now") {

            }
        }
    }
}