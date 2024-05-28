package com.example.asm_kot104.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.asm_kot104.R
import com.example.asm_kot104.model.Cart
import com.example.asm_kot104.model.Category
import com.example.asm_kot104.model.Product


@Composable
fun CartItem(
    item: Cart
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            AsyncImage(
                model = item.idProduct.images[0], contentDescription = null,
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = item.idProduct.name, style = MaterialTheme.typography.bodyLarge)
                        Text(
                            text = "${item.idProduct.price} VNĐ",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    MIcon(iconId = R.drawable.ic_launcher_foreground) {

                    }
                    Text("${item.quantity}", modifier = Modifier.padding(10.dp))
                    MIcon(iconId = R.drawable.ic_launcher_foreground) {

                    }
                }
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(1.dp)
            .background(Color(0xFFDFDFDF)))
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemPreview() {
    CartItem(
        item = Cart(
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
}