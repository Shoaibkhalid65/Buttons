package com.example.buttons.weather

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.rememberLottieDynamicProperties
import com.airbnb.lottie.compose.rememberLottieDynamicProperty
import com.example.buttons.R
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.NeuAttrs
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Pressed
import com.gandiva.neumorphic.shape.RoundedCorner


@Composable
fun WeatherScreen1(){
    val neuAttrs= NeuAttrs(
        lightShadowColor =Color(0x66494949),
        darkShadowColor = Color(0x66000000),
        shadowElevation = 12.dp,
        shape = Pressed(RoundedCorner(12.dp)),
        lightSource = LightSource.LEFT_BOTTOM
    )

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.code_green))
        val progress by animateLottieCompositionAsState(
            composition=composition,
            iterations = LottieConstants.IterateForever
        )
        LaunchedEffect(composition) {
            composition?.layers?.forEach {
                Log.d("LottieLayer", "$it?.name")
            }
        }

        val dynamicProps = rememberLottieDynamicProperties(
            rememberLottieDynamicProperty(
                property = LottieProperty.COLOR_FILTER,
                value = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
                    android.graphics.Color.BLUE,
                    BlendModeCompat.SRC_OVER
                ),
                keyPath = arrayOf("cloud","**")
            )
        )
        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .size(200.dp)
                .neu(neuAttrs=neuAttrs),
            progress={progress},
            dynamicProperties = dynamicProps

        )

    }
}
@Preview(showBackground = true, backgroundColor =0xFF303234 )
@Composable
fun WeatherScreen1Preview(){
    WeatherScreen1()
}

