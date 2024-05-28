package com.example.asm_kot104.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.asm_kot104.R
import com.example.asm_kot104.model.Category
import com.example.asm_kot104.model.Product
import com.example.asm_kot104.model.Screen
import com.example.asm_kot104.ui.components.HeaderApp
import com.example.asm_kot104.ui.components.ItemHome
import com.example.asm_kot104.ui.components.MIcon
import com.example.asm_kot104.ui.theme.ASM_KOT104Theme

@Composable
fun HomeScreen(navController: NavController) {
    val listIconId =
        intArrayOf(R.drawable.grid, R.drawable.vegetable, R.drawable.fruits, R.drawable.drink)
    val list = listOf(
        Product(
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
        Product(
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
        Product(
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
        Product(
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
        Product(
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
        )
    )
    Column {
        HeaderApp(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.LightGray
                    )
                ) {
                    append("Make house")
                }
                withStyle(
                    SpanStyle(
                        color = Color.Black,
                    )
                ) {
                    append("\nBeautiful")
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
        ListIcon(listIconId)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            Modifier.padding(10.dp)
        ) {
            items(list) { item ->
                ItemHome(item, onClick = {
                    navController.navigate(Screen.VIEW_DETAIL_SCREEN.name)
                })
            }
        }
    }
}

@Composable
fun ListIcon(listIconId: IntArray) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        for (i in listIconId) {
            MIcon(iconId = i) {

            }
        }
    }
}