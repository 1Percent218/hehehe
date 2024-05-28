package com.example.asm_kot104.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.asm_kot104.model.Category
import com.example.asm_kot104.model.Product

@Composable
fun ItemHome(item: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .clickable(enabled = true, onClick = onClick),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(6.dp)
    ) {
        ConstraintLayout(modifier = Modifier.padding(4.dp)) {
            val (imgRef, cateRef, nameRef, priceRef, btnRef) = createRefs()
            AsyncImage(
                model = item.images[0],
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(imgRef) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .clip(RoundedCornerShape(4.dp)),
            )
            Text(text = item.categoryId.name,
                modifier = Modifier.constrainAs(cateRef) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                })
            Text(text = item.name,
                modifier = Modifier.constrainAs(nameRef) {
                    top.linkTo(imgRef.bottom)
                    start.linkTo(imgRef.start)
                })
            Text(text = "${item.price} VNĐ",
                modifier = Modifier.constrainAs(priceRef) {
                    top.linkTo(nameRef.bottom)
                    start.linkTo(nameRef.start)
                    bottom.linkTo(btnRef.top)
                })
            ButtonFilled(text = "Add to cart",
                modifier = Modifier
                    .constrainAs(btnRef) {
                        bottom.linkTo(parent.bottom)
                    }
                    .fillMaxWidth()) {

            }
        }
    }
}