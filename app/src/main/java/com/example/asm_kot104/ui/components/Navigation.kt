package com.example.asm_kot104.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.asm_kot104.model.Category
import com.example.asm_kot104.model.Product
import com.example.asm_kot104.model.Screen
import com.example.asm_kot104.ui.screens.CartScreen
import com.example.asm_kot104.ui.screens.HomeScreen
import com.example.asm_kot104.ui.screens.LoginScreenPromax
import com.example.asm_kot104.ui.screens.MyOrderScreen
import com.example.asm_kot104.ui.screens.RegisterScreenPromax
import com.example.asm_kot104.ui.screens.SearchScreen
import com.example.asm_kot104.ui.screens.ShippingAddressScreen
import com.example.asm_kot104.ui.screens.ViewDetailScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val item =
        Product(
            _id = "",
            name = "Capuchino",
            images = listOf(
                "https://media.saigontourist.edu.vn/Media/1_STHCHOME/FolderFunc/202303/Images/capuchino-la-gi-20230320105423-e.jpg",
                "https://tse1.mm.bing.net/th?id=OIP.06dd8mqOosBGQLjQWZIXAQHaE8&pid=Api&P=0&h=180",
                "https://thienhatcoffee.com/wp-content/uploads/2022/03/capuchino-la-gi.jpg"
            ),
            price = 59000,
            description = "Cappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sữa nóng với bề mặt được phủ bằng bọt sữa. Cappuccino thường được pha bởi máy pha cà phê Espresso. Cafe espresso được rót vào cốc, sau đó cho một lượng sữa nóng được tạo ra bằng cách đun nóng sữa bằng đũa hơi, trên cùng là lớp bọt sữa.",
            categoryId = Category(_id = "660b727f19117d400e56232f"))

    NavHost(navController = navController, startDestination = Screen.LOGIN_SCREEN.name) {
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
        composable(Screen.VIEW_DETAIL_SCREEN.name){
            ViewDetailScreen(item = item, navController)
        }
        composable(Screen.SEARCH_SCREEN.name){
            SearchScreen(navController)
        }
    }
}