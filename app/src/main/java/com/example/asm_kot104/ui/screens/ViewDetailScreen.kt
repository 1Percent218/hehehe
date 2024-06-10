package com.example.asm_kot104.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.asm_kot104.model.Category
import com.example.asm_kot104.model.Product
import com.example.asm_kot104.ui.components.ButtonOutline
import com.example.asm_kot104.viewmodel.ProductViewModel

@Composable
fun ViewDetailScreen(id: String, productViewModel: ProductViewModel = viewModel()) {
    Log.d("ViewDetailScreen", "ViewDetailScreen: $id")
    val item by productViewModel.product
    productViewModel.getProductById(id)
    if(item == null) return
//        Product(
//            _id = "",
//            name = "Capuchino",
//            images = listOf(
//                "https://media.saigontourist.edu.vn/Media/1_STHCHOME/FolderFunc/202303/Images/capuchino-la-gi-20230320105423-e.jpg",
//                "https://tse1.mm.bing.net/th?id=OIP.06dd8mqOosBGQLjQWZIXAQHaE8&pid=Api&P=0&h=180",
//                "https://thienhatcoffee.com/wp-content/uploads/2022/03/capuchino-la-gi.jpg"
//            ),
//            price = 59000,
//            description = "Cappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sCappuccino là một thức uống bao gồm cafe espresso, sữa nóng với bề mặt được phủ bằng bọt sữa. Cappuccino thường được pha bởi máy pha cà phê Espresso. Cafe espresso được rót vào cốc, sau đó cho một lượng sữa nóng được tạo ra bằng cách đun nóng sữa bằng đũa hơi, trên cùng là lớp bọt sữa.",
//            categoryId = Category(_id = "660b727f19117d400e56232f"))
    var currentImage by remember {
        mutableStateOf(item!!.images?.get(0))
    }

    var scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        AsyncImage(
            model = currentImage,
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            items(item!!.images!!) { item ->
                AsyncImage(
                    model = item,
                    contentDescription = "Item Image",
                    modifier = Modifier
                        .size(100.dp)
                        .clickable {
                            currentImage = item
                        },
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row (horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()){
                item!!.name?.let {
                    Text(
                        text = it,
                        color = Color(0xFF474747),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                ButtonOutline(text = "Buy now") {
                    
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Giá: ${item!!.price} VNĐ",
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            item!!.description?.let {
                Text(
                    text = it,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}