package com.example.buttons.neumorphism

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Egg
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buttons.ui.theme.ButtonBackgroundColor
import com.example.buttons.ui.theme.ButtonIconColor
import com.example.buttons.ui.theme.ButtonTextColor
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Pressed
import com.gandiva.neumorphic.shape.RoundedCorner

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ButtonNeumorphismSample1(){
    val size= ButtonDefaults.ExtraSmallContainerHeight
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = ButtonBackgroundColor
            ),
        contentAlignment = Alignment.Center
    ){
        Button(
            onClick = {},
            modifier = Modifier
                .heightIn(size)
                .neu(
                    lightShadowColor = Color(0xFFFFFFFF),
                    darkShadowColor = Color(0xFFA8B5C7),
                    shadowElevation = 12.dp,
                    shape = Pressed(RoundedCorner(12.dp)),
                    lightSource = LightSource.LEFT_TOP
                )
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(16.dp),
                    ambientColor = Color.Red,
                    spotColor = Color.Red
                ),
                shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = ButtonBackgroundColor
            ),
            contentPadding = ButtonDefaults.contentPaddingFor(size)
        ) {
            Icon(
                imageVector = Icons.Outlined.Egg,
                contentDescription = "favorite icon",
                tint = ButtonIconColor,
                modifier = Modifier.size(ButtonDefaults.iconSizeFor(size))
            )
            Spacer(
                modifier = Modifier
                    .size(ButtonDefaults.iconSpacingFor(size))
            )
            Text(
                text = "Like",
                color = ButtonTextColor,
                style = ButtonDefaults.textStyleFor(size),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun ButtonNeumorphismSample1Preview(){
  ButtonNeumorphismSample1()
}