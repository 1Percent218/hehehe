package com.example.asm_kot104.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderApp(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    iconLeft: ImageVector?,
    iconRight: ImageVector?,
    iconLeftOnClick: () -> Unit,
    iconRightOnClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        if (iconLeft == null) {
            Spacer(modifier = Modifier.width(48.dp))
        } else {
            IconButton(onClick = iconLeftOnClick) {
                Icon(imageVector = iconLeft, contentDescription = null)
            }
        }
        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        if (iconRight == null) {
            Spacer(modifier = Modifier.width(48.dp))
        } else {
            IconButton(onClick = iconRightOnClick) {
                Icon(imageVector = iconRight, contentDescription = null)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderAppPreview() {
    HeaderApp(
        text = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    color = Color.LightGray
                )
            ) {
                append("Make house")
            }
            withStyle(
                SpanStyle(
                    color = Color.Black,
                )
            ) {
                append("\nBeautiful")
            }
        },
        iconLeft = Icons.Default.Search,
        iconRight = Icons.Default.ShoppingCart,
        iconLeftOnClick = {},
        iconRightOnClick = {},
    )
}