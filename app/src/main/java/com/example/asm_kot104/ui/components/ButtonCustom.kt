package com.example.asm_kot104.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.asm_kot104.R

@Composable
fun ButtonFilled(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xff416D19)
        )
    ) {
        Text(text = text)
    }
}


@Composable
fun ButtonOutline(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color(0xff416D19)),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xff416D19),
            containerColor = Color(0x00ffffff),
        )
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
private fun ButtonFilledPreview() {
    ButtonFilled(text = "Button Preview") {

    }
}

@Preview
@Composable
private fun ButtonOutlinePreview() {
    ButtonOutline(text = "Button Preview") {

    }
}