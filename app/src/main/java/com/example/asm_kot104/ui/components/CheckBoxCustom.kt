package com.example.asm_kot104.ui.components

import android.widget.CheckBox
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxCustom(
    modifier: Modifier = Modifier,
    isCheck: Boolean,
    text: String,
    onChangeChecked: (b: Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = isCheck,
            onCheckedChange = onChangeChecked,
            modifier = Modifier.padding(0.dp)
        )
        Text(
            text = text, style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CheckBoxCustomPreview() {
    var isCheck by remember {
        mutableStateOf(false)
    }
    CheckBoxCustom(isCheck = isCheck, text = "test checkbox") {
        isCheck = it
    }
}