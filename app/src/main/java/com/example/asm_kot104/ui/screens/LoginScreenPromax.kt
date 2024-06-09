package com.example.asm_kot104.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.ui.Alignment
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.asm_kot104.R
import com.example.asm_kot104.model.Account
import com.example.asm_kot104.model.Screen
import com.example.asm_kot104.ui.components.ButtonFilled
import com.example.asm_kot104.ui.components.ButtonOutline
import com.example.asm_kot104.ui.components.CheckBoxCustom
import com.example.asm_kot104.ui.components.EditText
import com.example.asm_kot104.viewmodel.LoginViewModel

@Composable
fun LoginScreenPromax(navController: NavController, loginViewModel: LoginViewModel = viewModel()) {
    ConstraintLayout {
        val (helloRef,
            cardRef,
            textRef,
            rowRef,
            registerRef,
            bgr) = createRefs()
        var isCheckRemember by remember {
            mutableStateOf(false)
        }
        val loginResult by loginViewModel.loginResult.observeAsState()
        val errorMessage by loginViewModel.errorMessage.observeAsState()
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Image(
            painter = painterResource(id = R.drawable.bgr_login),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(bgr) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Hello !")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("\nWELCOME BACK")
                }
            },
            modifier = Modifier.constrainAs(helloRef) {
                bottom.linkTo(cardRef.top)
                start.linkTo(cardRef.start)
            },
            style = MaterialTheme.typography.headlineLarge
        )
        Card(colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .padding(10.dp)
                .constrainAs(cardRef) {
                    bottom.linkTo(parent.bottom)
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth(0.85f)) {
            Column(modifier = Modifier.padding(20.dp)) {
                Spacer(modifier = Modifier.height(10.dp))
                EditText(value = email, label = "Email") {
                    email = it
                }
                EditText(value = password, label = "Password") {
                    password = it
                }
                CheckBoxCustom(isCheck = isCheckRemember, text = "Remember password") {
                    isCheckRemember = it
                }
                errorMessage?.let {
                    Text("Error: $it")
                }
                ButtonFilled(text = "Log in", modifier = Modifier.fillMaxWidth()) {
                    loginViewModel.login(Account(email, password))

                }
                loginResult?.let {
                    navController.navigate(Screen.HOME_SCREEN.name)
                }
                TextButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Forgot Password?")
                }
            }
        }
        Text(text = "or connected with",
            modifier = Modifier.constrainAs(textRef) {
                top.linkTo(cardRef.bottom)
                start.linkTo(cardRef.start)
                end.linkTo(cardRef.end)
                bottom.linkTo(rowRef.top)
            })
        Row(modifier = Modifier.constrainAs(rowRef) {
            bottom.linkTo(registerRef.top)
            top.linkTo(textRef.bottom)
            start.linkTo(cardRef.start)
            end.linkTo(cardRef.end)
        }) {
            Image(painter = painterResource(id = R.drawable.facebook), contentDescription = null)
            Image(painter = painterResource(id = R.drawable.instagram), contentDescription = null)
        }
        ButtonOutline(text = "Create an account?",
            modifier = Modifier
                .constrainAs(registerRef) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(cardRef.start)
                    end.linkTo(cardRef.end)
                }
                .fillMaxWidth(0.8f)
        ) {
            navController.navigate(Screen.REGISTER_SCREEN.name)
        }
    }
}
