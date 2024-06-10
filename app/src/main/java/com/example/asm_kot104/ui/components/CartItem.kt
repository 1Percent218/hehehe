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
import androidx.compose.material3.IconButton
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
    item: Cart,
    onMinus: ()->Unit,
    onPlus:()-> Unit,
    onDelete:()->Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            AsyncImage(
                model = item.idProduct?.images?.get(0), contentDescription = null,
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
                        item.idProduct?.name?.let { Text(text = it, style = MaterialTheme.typography.bodyLarge) }
                        Text(
                            text = "${item.idProduct?.price} VNĐ",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    IconButton(onClick = onDelete) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "")
                    }
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    MIcon(iconId = R.drawable.baseline_minimize_24, onClick = onMinus)
                    Text("${item.quantity}", modifier = Modifier.padding(10.dp))
                    MIcon(iconId = R.drawable.baseline_add_24, onClick = onPlus)
                }
            }
        }
        Box(modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(1.dp)
            .background(Color(0xFFDFDFDF)))
    }
}