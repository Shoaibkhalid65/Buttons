package com.example.buttons.neumorphism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.NeuAttrs
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Pressed
import com.gandiva.neumorphic.shape.RoundedCorner


@Composable
fun NeumorphismSample3(){
    
    val neuAttrs= NeuAttrs(
        lightShadowColor =Color(0x66494949),
        darkShadowColor = Color(0x66000000),
        shadowElevation = 12.dp,
        shape = Pressed(RoundedCorner(12.dp)),
        lightSource = LightSource.RIGHT_TOP
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF303234)),
        contentAlignment = Alignment.Center
    ){
        Card(
            modifier = Modifier
                .size(128.dp)
                .neu(
                    neuAttrs = neuAttrs
                ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 0.dp
            ),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF303234)
            ),
        ) {

        }
    }
}
@Preview
@Composable
fun  NeumorphismSample3Preview(){
    NeumorphismSample3()
}