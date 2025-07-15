package com.example.buttons.composeButtons

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ElevatedButtonSample(){
    ElevatedButton(
        onClick = {},
        shapes = ButtonDefaults.shapes(),


    ) {
        Text(
            text = "Button"
        )
    }
}

@Preview
@Composable
fun ElevatedButtonSamplePreview(){
    ElevatedButtonSample()
}