package com.example.buttons.neumorphism

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.buttons.composeButtons.coloredShadow
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.CornerShape
import com.gandiva.neumorphic.shape.Flat
import com.gandiva.neumorphic.shape.NeuShape
import com.gandiva.neumorphic.shape.Pressed
import com.gandiva.neumorphic.shape.RoundedCorner

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun NeumorphismSample2(){
    Button(
        modifier = Modifier
            .defaultMinSize(minHeight = 80.dp)
            .fillMaxWidth()
            .padding(20.dp)
            .neu(
                lightShadowColor = Color(0xFFFFFFFF),
                darkShadowColor = Color(0xFFA8B5C7),
                shadowElevation = 12.dp,
                shape = Pressed(RoundedCorner(12.dp)),
                lightSource = LightSource.LEFT_BOTTOM
            ),
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFDCDCDC)
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 16.dp
        ),
    ) {
        Text(
            text = "Button",
            color = Color.Black
        )
    }
}
@Preview(backgroundColor =  0xFFDCDCDC, showBackground = true)
@Composable
fun NeumorphismSample2Preview(){
    NeumorphismSample2()
}

