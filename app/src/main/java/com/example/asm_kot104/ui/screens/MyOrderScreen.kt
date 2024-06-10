package com.example.asm_kot104.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.asm_kot104.model.Bill
import com.example.asm_kot104.model.Screen
import com.example.asm_kot104.ui.components.ButtonFilled
import com.example.asm_kot104.ui.components.HeaderApp
import com.example.asm_kot104.viewmodel.BillViewModel

@Composable
fun MyOrderScreen(navController: NavController, billViewModel: BillViewModel = viewModel()) {
    val list by billViewModel.bills
    Column {
        HeaderApp(text = buildAnnotatedString { append("My order") },
            iconLeft = Icons.Default.ArrowBack,
            iconRight = null,
            iconLeftOnClick = {
                navController.popBackStack()
            },
            iconRightOnClick = {}
        )
        LazyColumn {
            items(list) {
                MyOrderItem(it) { bill ->
                    navController.navigate("${Screen.BILL_DETAILS_SCREEN}/${bill.get_id()}")
                }
            }
        }
    }
}

@Composable
fun MyOrderItem(item: Bill, detailOnClick: (Bill) -> Unit) {
    Card(
        modifier = Modifier.padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            val (text1Ref, text2Ref, text3Ref, text4Ref, text5Ref, buttonRef) = createRefs()
            Text(
                text = "Order ${item.get_id()?.takeLast(5)}",
                modifier = Modifier.constrainAs(text1Ref) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })
            Text(text = "${item.date}", modifier = Modifier.constrainAs(text2Ref) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            })
            Text(text = "Quantity: ${item.sum}", modifier = Modifier.constrainAs(text3Ref) {
                top.linkTo(text1Ref.bottom)
                start.linkTo(parent.start)
            })
            Text(text = "Total Amount: ${item.total}", modifier = Modifier.constrainAs(text4Ref) {
                top.linkTo(text1Ref.bottom)
                end.linkTo(parent.end)
            })
            Text(text = "Delivered", modifier = Modifier.constrainAs(text5Ref) {
                top.linkTo(buttonRef.top)
                bottom.linkTo(buttonRef.bottom)
                end.linkTo(parent.end)
            })
            ButtonFilled(text = "Detail", modifier = Modifier.constrainAs(buttonRef) {
                top.linkTo(text4Ref.bottom)
                start.linkTo(parent.start)
            }) {
                detailOnClick(item)
            }
        }
    }
}
