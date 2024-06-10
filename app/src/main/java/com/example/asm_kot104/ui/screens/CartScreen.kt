package com.example.asm_kot104.ui.screens

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.asm_kot104.ui.components.ButtonFilled
import com.example.asm_kot104.ui.components.CartItem
import com.example.asm_kot104.ui.components.HeaderApp
import com.example.asm_kot104.viewmodel.CartViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.asm_kot104.model.Cart
import com.example.asm_kot104.model.Screen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CartScreen(navController: NavController, viewModel: CartViewModel = viewModel()) {
    val list by viewModel.carts
    var isShowConfirm by remember {
        mutableStateOf(false)
    }
    var itemDelete by remember {
        mutableStateOf(Cart())
    }
    var totalPrice by remember {
        mutableStateOf(0)
    }
    var isShowAlert by remember {
        mutableStateOf(false)
    }
    if (list.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Giỏ hàng trống, thêm sản phẩm vào giỏ")
            val composition by rememberLottieComposition(LottieCompositionSpec.Asset("cart_animation.json"))
            val progress by animateLottieCompositionAsState(
                composition,
                iterations = LottieConstants.IterateForever
            )
            LottieAnimation(
                composition,
                progress,
                modifier = Modifier.size(200.dp)
            )
        }
    }
    if (isShowAlert) {
        AlertDialog(
            onDismissRequest = { isShowAlert = false },
            confirmButton = {
                Button(onClick = { isShowAlert = false }) {
                    Text(text = "OK")
                }
            },
            title = { Text(text = "Thông báo") },
            text = { Text(text = "Vui lòng thêm sản phẩm vào giỏ hàng để thực hiện chức năng này") },
        )
    }
    totalPrice = viewModel.getTotalPrice()
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (headerRef, listRef, bottomRef) = createRefs()
        HeaderApp(
            text = buildAnnotatedString { append("Cart") },
            iconLeft = Icons.Default.ArrowBack,
            iconRight = Icons.Default.List,
            iconLeftOnClick = {
                navController.popBackStack()
            },
            iconRightOnClick = {
                navController.navigate(Screen.MY_ORDER_SCREEN.name)
            },
            modifier = Modifier.constrainAs(headerRef) {
                top.linkTo(parent.top)
            })
        if (isShowConfirm) {
            AlertDialog(
                onDismissRequest = {
                    isShowConfirm = false
                },
                confirmButton = {
                    Button(onClick = {
                        viewModel.deleteCart(itemDelete._id!!)
                        isShowConfirm = false
                    }) {
                        Text(text = "Xóa")
                    }
                },
                dismissButton = {
                    Button(onClick = { isShowConfirm = false }) {
                        Text(text = "Hủy")
                    }
                },
                text = {
                    Text(text = "Bạn có chắc chắn muốn xóa sản phẩm này khỏi giỏ hàng?")
                },
                title = {
                    Text(text = "Cảnh báo")
                },
            )
        }

        LazyColumn(modifier = Modifier
            .constrainAs(listRef) {
                top.linkTo(headerRef.bottom)
            }
            .fillMaxSize()) {
            items(list) { item ->
                CartItem(
                    item = item,
                    onPlus = {
                        item.quantity++
                        viewModel.updateCart(item, item._id!!)
                    },
                    onMinus = {
                        if (item.quantity == 1) {
                            itemDelete = item
                            isShowConfirm = true
                            return@CartItem
                        }
                        item.quantity--
                        viewModel.updateCart(item, item._id!!)
                    },
                    onDelete = {
                        itemDelete = item
                        isShowConfirm = true
                    }
                )
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
            Text(text = "Tổng tiền: ${totalPrice} VND")
            ButtonFilled(text = "Buy now") {
                if (totalPrice == 0) {
                    isShowAlert = true
                    return@ButtonFilled
                }
                viewModel.buyNow()
                navController.navigate(Screen.NOTI_SCREEN.name)
            }
        }
    }
}