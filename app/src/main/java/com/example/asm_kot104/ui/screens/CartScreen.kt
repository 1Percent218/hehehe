package com.example.asm_kot104.ui.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun CartScreen(navController: NavController) {
    val list = listOf<Cart>(
        Cart(
            _id = "",
            idAccount = "",
            idProduct = Product(
                _id = "",
                name = "Capuchino",
                images = listOf(
                    "https://media.saigontourist.edu.vn/Media/1_STHCHOME/FolderFunc/202303/Images/capuchino-la-gi-20230320105423-e.jpg",
                    "https://tse1.mm.bing.net/th?id=OIP.06dd8mqOosBGQLjQWZIXAQHaE8&pid=Api&P=0&h=180",
                    "https://thienhatcoffee.com/wp-content/uploads/2022/03/capuchino-la-gi.jpg"
                ),
                price = 59000,
                description = "Cappuccino là một thức uống bao gồm cafe espresso, sữa nóng với bề mặt được phủ bằng bọt sữa. Cappuccino thường được pha bởi máy pha cà phê Espresso. Cafe espresso được rót vào cốc, sau đó cho một lượng sữa nóng được tạo ra bằng cách đun nóng sữa bằng đũa hơi, trên cùng là lớp bọt sữa.",
                categoryId = Category(_id = "660b727f19117d400e56232f")
            ),
            quantity = 1
        ),

        Cart(
            _id = "",
            idAccount = "",
            idProduct = Product(
                _id = "",
                name = "Capuchino",
                images = listOf(
                    "https://media.saigontourist.edu.vn/Media/1_STHCHOME/FolderFunc/202303/Images/capuchino-la-gi-20230320105423-e.jpg",
                    "https://tse1.mm.bing.net/th?id=OIP.06dd8mqOosBGQLjQWZIXAQHaE8&pid=Api&P=0&h=180",
                    "https://thienhatcoffee.com/wp-content/uploads/2022/03/capuchino-la-gi.jpg"
                ),
                price = 59000,
                description = "Cappuccino là một thức uống bao gồm cafe espresso, sữa nóng với bề mặt được phủ bằng bọt sữa. Cappuccino thường được pha bởi máy pha cà phê Espresso. Cafe espresso được rót vào cốc, sau đó cho một lượng sữa nóng được tạo ra bằng cách đun nóng sữa bằng đũa hơi, trên cùng là lớp bọt sữa.",
                categoryId = Category(_id = "660b727f19117d400e56232f")
            ),
            quantity = 1
        ),

        Cart(
            _id = "",
            idAccount = "",
            idProduct = Product(
                _id = "",
                name = "Capuchino",
                images = listOf(
                    "https://media.saigontourist.edu.vn/Media/1_STHCHOME/FolderFunc/202303/Images/capuchino-la-gi-20230320105423-e.jpg",
                    "https://tse1.mm.bing.net/th?id=OIP.06dd8mqOosBGQLjQWZIXAQHaE8&pid=Api&P=0&h=180",
                    "https://thienhatcoffee.com/wp-content/uploads/2022/03/capuchino-la-gi.jpg"
                ),
                price = 59000,
                description = "Cappuccino là một thức uống bao gồm cafe espresso, sữa nóng với bề mặt được phủ bằng bọt sữa. Cappuccino thường được pha bởi máy pha cà phê Espresso. Cafe espresso được rót vào cốc, sau đó cho một lượng sữa nóng được tạo ra bằng cách đun nóng sữa bằng đũa hơi, trên cùng là lớp bọt sữa.",
                categoryId = Category(_id = "660b727f19117d400e56232f")
            ),
            quantity = 1
        ),

        Cart(
            _id = "",
            idAccount = "",
            idProduct = Product(
                _id = "",
                name = "Capuchino",
                images = listOf(
                    "https://media.saigontourist.edu.vn/Media/1_STHCHOME/FolderFunc/202303/Images/capuchino-la-gi-20230320105423-e.jpg",
                    "https://tse1.mm.bing.net/th?id=OIP.06dd8mqOosBGQLjQWZIXAQHaE8&pid=Api&P=0&h=180",
                    "https://thienhatcoffee.com/wp-content/uploads/2022/03/capuchino-la-gi.jpg"
                ),
                price = 59000,
                description = "Cappuccino là một thức uống bao gồm cafe espresso, sữa nóng với bề mặt được phủ bằng bọt sữa. Cappuccino thường được pha bởi máy pha cà phê Espresso. Cafe espresso được rót vào cốc, sau đó cho một lượng sữa nóng được tạo ra bằng cách đun nóng sữa bằng đũa hơi, trên cùng là lớp bọt sữa.",
                categoryId = Category(_id = "660b727f19117d400e56232f")
            ),
            quantity = 1
        ),
        Cart(
            _id = "",
            idAccount = "",
            idProduct = Product(
                _id = "",
                name = "Capuchino",
                images = listOf(
                    "https://media.saigontourist.edu.vn/Media/1_STHCHOME/FolderFunc/202303/Images/capuchino-la-gi-20230320105423-e.jpg",
                    "https://tse1.mm.bing.net/th?id=OIP.06dd8mqOosBGQLjQWZIXAQHaE8&pid=Api&P=0&h=180",
                    "https://thienhatcoffee.com/wp-content/uploads/2022/03/capuchino-la-gi.jpg"
                ),
                price = 59000,
                description = "Cappuccino là một thức uống bao gồm cafe espresso, sữa nóng với bề mặt được phủ bằng bọt sữa. Cappuccino thường được pha bởi máy pha cà phê Espresso. Cafe espresso được rót vào cốc, sau đó cho một lượng sữa nóng được tạo ra bằng cách đun nóng sữa bằng đũa hơi, trên cùng là lớp bọt sữa.",
                categoryId = Category(_id = "660b727f19117d400e56232f")
            ),
            quantity = 1
        )
    )
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