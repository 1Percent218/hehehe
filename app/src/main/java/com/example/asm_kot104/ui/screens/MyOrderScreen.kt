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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.asm_kot104.ui.components.ButtonFilled
import com.example.asm_kot104.ui.components.HeaderApp

@Composable
fun MyOrderScreen(navController: NavController) {
    Column {
        HeaderApp(text = buildAnnotatedString { append("My order") },
            iconLeft = Icons.Default.ArrowBack,
            iconRight = null,
            iconLeftOnClick = { /*TODO*/ },
            iconRightOnClick = {}
        )
        LazyColumn {
            items(listOf(1,2,3,4)){
                MyOrderItem()
            }
        }
    }
}

@Composable
fun MyOrderItem(modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
            val (text1Ref, text2Ref, text3Ref, text4Ref, text5Ref, buttonRef) = createRefs()
            Text(text = "Order No238562312", modifier = Modifier.constrainAs(text1Ref){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            })
            Text(text = "20/03/2020", modifier = Modifier.constrainAs(text2Ref){
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            })
            Text(text = "Quantity: 03", modifier = Modifier.constrainAs(text3Ref){
                top.linkTo(text1Ref.bottom)
                start.linkTo(parent.start)
            })
            Text(text = "Total Amount: \$150", modifier = Modifier.constrainAs(text4Ref){
                top.linkTo(text1Ref.bottom)
                end.linkTo(parent.end)
            })
            Text(text = "Delivered", modifier = Modifier.constrainAs(text5Ref){
                top.linkTo(buttonRef.top)
                bottom.linkTo(buttonRef.bottom)
                end.linkTo(parent.end)
            })
            ButtonFilled(text = "Detail", modifier = Modifier.constrainAs(buttonRef){
                top.linkTo(text4Ref.bottom)
                start.linkTo(parent.start)
            }) {

            }
        }
    }
}
