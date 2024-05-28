package com.example.asm_kot104.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.asm_kot104.model.Category
import com.example.asm_kot104.model.Product
import com.example.asm_kot104.model.Screen
import com.example.asm_kot104.ui.components.EditText
import com.example.asm_kot104.ui.components.ItemHome

@Composable
fun SearchScreen(navController: NavController) {
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
        TextField(value = "",
            onValueChange = {},
            placeholder = { Text(text = "enter your keyword") },
            modifier = Modifier.fillMaxWidth())
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