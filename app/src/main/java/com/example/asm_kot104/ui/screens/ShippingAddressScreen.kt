package com.example.asm_kot104.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.asm_kot104.ui.components.ButtonFilled
import com.example.asm_kot104.ui.components.EditText
import com.example.asm_kot104.ui.components.HeaderApp

@Composable
fun ShippingAddressScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp, 0.dp)) {
        HeaderApp(text = buildAnnotatedString { append("Add shipping address") },
            iconLeft = Icons.Default.ArrowBack,
            iconRight = null,
            iconLeftOnClick = { /*TODO*/ },
            iconRightOnClick = { })

        EditText(value = "", label = "Full name") {

        }
        EditText(value = "", label = "Address") {

        }
        EditText(value = "", label = "Zipcode (Postal Code)") {

        }
        EditText(value = "", label = "Country") {

        }
        EditText(value = "", label = "City") {

        }
        EditText(value = "", label = "District") {

        }
        Spacer(modifier = Modifier.height(40.dp))
        ButtonFilled(text = "Save address", modifier = Modifier.fillMaxWidth()) {
            
        }
    }
}