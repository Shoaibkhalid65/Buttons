package com.example.buttons.neumorphism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NeumorphismSample1(){
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(16.dp))
            .shadow(20.dp, shape = RoundedCornerShape(32.dp), ambientColor = Color.White, spotColor = Color.Gray)
    )

}