package com.example.asm_kot104.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.asm_kot104.model.BillDetails
import com.example.asm_kot104.ui.components.HeaderApp
import com.example.asm_kot104.viewmodel.BillDetailsViewModel

@Composable
fun BillDetailsScreen(
    id: String,
    navController: NavController,
    billDetailsViewModel: BillDetailsViewModel = viewModel()
) {
    val list by billDetailsViewModel.billDetails
    billDetailsViewModel.getAllBillDetails(id)
    Column {
        HeaderApp(text = buildAnnotatedString { append("View bill details") },
            iconLeft = Icons.Default.ArrowBack,
            iconRight = null,
            iconLeftOnClick = {
                navController.popBackStack()
            },
            iconRightOnClick = {}
        )
        LazyColumn {
            items(list) {
                BillDetailItem(item = it)
            }
        }
    }
}

@Composable
fun BillDetailItem(item: BillDetails) {
    val product = item.productId
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row {
            AsyncImage(
                model = product?.images?.get(0),
                contentDescription = "Ảnh sản phẩm",
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(4.dp)) {
                item.get_id()?.let { Text(text = it.takeLast(5)) }
                Text(text = "Tên: ${product?.name}")
                Text(text = "Giá: ${product?.price}")
                Text(text = "Số lượng: ${item.quantity}")
            }
        }
    }
}