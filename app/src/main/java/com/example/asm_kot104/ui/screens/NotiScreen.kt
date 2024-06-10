package com.example.asm_kot104.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.asm_kot104.R
import com.example.asm_kot104.model.Screen
import com.example.asm_kot104.ui.components.ButtonFilled
import com.example.asm_kot104.ui.components.ButtonOutline

@Composable
fun NotiScreen(navController: NavController) {
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()) {
        Text(text = "Success!", style = MaterialTheme.typography.headlineLarge)

        val composition by rememberLottieComposition(LottieCompositionSpec.Asset("cart_succes_animation.json"))
        val progress by animateLottieCompositionAsState(
            composition,
            iterations = 1
        )
        LottieAnimation(
            composition,
            progress,
            modifier = Modifier.size(100.dp)
        )

        Text(text = "Your order will be delivered soon\nThank you for choosing our app", style = MaterialTheme.typography.bodySmall)
        ButtonFilled(text = "Track your orders") {
            navController.navigate(Screen.MY_ORDER_SCREEN.name)
        }
        ButtonOutline(text = "Back to home") {
            navController.navigate(Screen.HOME_SCREEN.name)
        }
    }
}