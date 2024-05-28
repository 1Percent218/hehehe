package com.example.asm_kot104.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EditText(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    onValueChange: (s: String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier.then(Modifier.fillMaxWidth()),
        singleLine = true,
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun EditTextPreview() {
    EditText(value = "Tui nè", label = "label") {

    }
}