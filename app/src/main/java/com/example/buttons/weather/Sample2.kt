package com.example.buttons.weather

import android.graphics.Color
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun WeatherScreen2(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        val composition by rememberLottieComposition(
            spec = LottieCompositionSpec.RawRes(R.raw.clear_night)
        )
        val progress by animateLottieCompositionAsState(
            composition=composition,
            iterations = LottieConstants.IterateForever
        )
        LaunchedEffect(composition) {
            composition?.layers?.forEach {
                Log.d("key path value ","$it?.name")
            }
        }
        val dynamicProperties= rememberLottieDynamicProperties(
            rememberLottieDynamicProperty(
                property = LottieProperty.COLOR_FILTER,
                value = BlendModeColorFilterCompat
                    .createBlendModeColorFilterCompat(
                        Color.YELLOW,
                        BlendModeCompat.SRC_OVER
                    ),
                keyPath = arrayOf(

                )
            )
        )
        LottieAnimation(
            composition=composition,
            progress={ progress },
            modifier = Modifier
                .size(200.dp),
            dynamicProperties=dynamicProperties
        )

    }
}
@Preview(showBackground = true, backgroundColor = Color.WHITE.toLong())
@Composable
fun WeatherScreen2Preview(){
    WeatherScreen2()
}