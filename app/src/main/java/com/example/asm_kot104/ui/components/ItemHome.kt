package com.example.asm_kot104.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.asm_kot104.model.Product

@Composable
fun ItemHome(item: Product, addToCart: (Product) -> Unit, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable(enabled = true, onClick = onClick),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFCFFFD)
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val (imgRef, cateRef, nameRef, priceRef, btnRef) = createRefs()
            AsyncImage(
                model = item.images?.get(0),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(imgRef) {
                        top.linkTo(parent.top, margin = 4.dp)
                        start.linkTo(parent.start, margin = 4.dp)
                        bottom.linkTo(parent.bottom, margin = 4.dp)
                    }
                    .clip(RoundedCornerShape(20.dp))
                    .size(100.dp),
                contentScale = ContentScale.Crop
            )
            item.categoryId?.categoryName?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .constrainAs(cateRef) {
                            top.linkTo(parent.top)
                            end.linkTo(parent.end)
                        }
                        .background(
                            Color(0xFFD5D5D5),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(4.dp),
                    style = TextStyle(
                        color = Color.White
                    )
                )
            }
            item.name?.let {
                Text(
                    text = it,
                    modifier = Modifier.constrainAs(nameRef) {
                        start.linkTo(imgRef.end, margin = 8.dp)
                        top.linkTo(imgRef.top, margin = 16.dp)
                    },
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
            Text(text = "${item.price} VNĐ",
                modifier = Modifier.constrainAs(priceRef) {
                    top.linkTo(nameRef.bottom, margin = 8.dp)
                    start.linkTo(nameRef.start)
                })
            ButtonFilled(text = "+",
                modifier = Modifier
                    .constrainAs(btnRef) {
                        bottom.linkTo(imgRef.bottom)
                        end.linkTo(parent.end, margin = 8.dp)
                    }) {
                addToCart(item)
            }
        }
    }
}