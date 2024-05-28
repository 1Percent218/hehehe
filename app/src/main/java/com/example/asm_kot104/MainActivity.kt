package com.example.asm_kot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.asm_kot104.model.Category
import com.example.asm_kot104.model.Product
import com.example.asm_kot104.ui.components.ButtonFilled
import com.example.asm_kot104.ui.components.ButtonOutline
import com.example.asm_kot104.ui.components.EditText
import com.example.asm_kot104.ui.components.MIcon
import com.example.asm_kot104.ui.components.Navigation
import com.example.asm_kot104.ui.screens.CartScreen
import com.example.asm_kot104.ui.screens.HomeScreen
import com.example.asm_kot104.ui.screens.LoginScreenPromax
import com.example.asm_kot104.ui.screens.MyOrderScreen
import com.example.asm_kot104.ui.screens.ShippingAddressScreen
import com.example.asm_kot104.ui.screens.ViewDetailScreen
import com.example.asm_kot104.ui.theme.ASM_KOT104Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ASM_KOT104Theme {
                Scaffold {
                    Column(modifier = Modifier.fillMaxSize().padding(it)) {
                        Navigation()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainPreview() {
    ASM_KOT104Theme {
    }
}