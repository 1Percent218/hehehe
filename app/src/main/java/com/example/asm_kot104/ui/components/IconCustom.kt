package com.example.asm_kot104.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.asm_kot104.R

@Composable
fun MIcon(
    modifier: Modifier = Modifier,
    iconId: Int,
    onClick: ()->Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xff000000),
            containerColor = Color(0xFFDDDDDD)
        ),
        modifier = modifier,
        shape = RoundedCornerShape(12.dp)
    ) {
        Icon(painter = painterResource(id = iconId), contentDescription = null, modifier = Modifier.size(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun IconPreview() {
    MIcon(iconId = R.drawable.ic_launcher_foreground){

    }
}