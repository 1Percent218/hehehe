package com.example.asm_kot104.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.asm_kot104.model.Category
import com.example.asm_kot104.model.Product
import com.example.asm_kot104.model.Screen
import com.example.asm_kot104.ui.screens.BillDetailsScreen
import com.example.asm_kot104.ui.screens.CartScreen
import com.example.asm_kot104.ui.screens.HomeScreen
import com.example.asm_kot104.ui.screens.LoginScreenPromax
import com.example.asm_kot104.ui.screens.MyOrderScreen
import com.example.asm_kot104.ui.screens.NotiScreen
import com.example.asm_kot104.ui.screens.RegisterScreenPromax
import com.example.asm_kot104.ui.screens.SearchScreen
import com.example.asm_kot104.ui.screens.ShippingAddressScreen
import com.example.asm_kot104.ui.screens.SplashScreen
import com.example.asm_kot104.ui.screens.ViewDetailScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HOME_SCREEN.name) {
        composable(Screen.CART_SCREEN.name) {
            CartScreen(navController)
        }
        composable(Screen.HOME_SCREEN.name) {
            HomeScreen(navController)
        }
        composable(Screen.LOGIN_SCREEN.name){
            LoginScreenPromax(navController)
        }
        composable(Screen.MY_ORDER_SCREEN.name){
            MyOrderScreen(navController)
        }
        composable(Screen.REGISTER_SCREEN.name){
            RegisterScreenPromax(navController)
        }
        composable(Screen.SHIPPING_ADDRESS_SCREEN.name){
            ShippingAddressScreen(navController)
        }
        composable("${Screen.VIEW_DETAIL_SCREEN.name}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })){
            it.arguments?.getString("id")?.let { it1 -> ViewDetailScreen(id = it1) }
        }
        composable(Screen.SEARCH_SCREEN.name){
            SearchScreen(navController)
        }
        composable(Screen.NOTI_SCREEN.name){
            NotiScreen(navController)
        }
        composable(Screen.SPLASH_SCREEN.name){
            SplashScreen(navController)
        }
        composable("${Screen.BILL_DETAILS_SCREEN.name}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })){
            it.arguments?.getString("id")?.let { it1 -> BillDetailsScreen(id = it1, navController) }
        }
    }
}