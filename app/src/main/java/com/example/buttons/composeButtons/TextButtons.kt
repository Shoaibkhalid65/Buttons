package com.example.buttons.composeButtons

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun TextButtonSample1(){
    TextButton(
        onClick = {},
        shapes = ButtonDefaults.shapes()
    ) {
        Text(
            text = "Text button"
        )
    }
}
@Preview(showBackground = true)
@Composable
fun TextButtonSample1Preview(){
    TextButtonSample1()
}