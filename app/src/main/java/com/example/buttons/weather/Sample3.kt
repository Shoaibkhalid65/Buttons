package com.example.buttons.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.buttons.R

@Composable
fun WeatherScreen3(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

            Image(
                painter = painterResource(R.drawable.cold_with_thermometer),
                contentDescription = "weather icon",
            )
        }

}
@Preview(showBackground = true, backgroundColor = android.graphics.Color.WHITE.toLong())
@Composable
fun WeatherScreen3Preview(){
    WeatherScreen3()
}