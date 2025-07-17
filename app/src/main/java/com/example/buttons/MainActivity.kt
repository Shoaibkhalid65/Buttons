package com.example.buttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.buttons.buttonGroups.Sample1
import com.example.buttons.splitButtons.CustomSplitButton
import com.example.buttons.splitButtons.SplitButtonWithDropdownMenuSample
import com.example.buttons.splitButtons.TonalSplitButtonSample
import com.example.buttons.weather.WeatherScreen1
import com.example.buttons.weather.WeatherScreen2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CustomSplitButton()
        }
    }
}

