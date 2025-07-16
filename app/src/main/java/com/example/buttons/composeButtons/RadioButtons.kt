package com.example.buttons.composeButtons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonSample1(){
    var isSelected by remember { mutableStateOf(true) }
    Column (
        modifier = Modifier.selectableGroup()
    ){
        Row {
            RadioButton(
                selected = isSelected,
                onClick = {
                    isSelected = true
                },
            )
            Text(
                text = "Option 1",
                modifier = Modifier.padding(top = 15.dp, end = 15.dp)
            )
        }
        Row {
            RadioButton(
                selected = !isSelected,
                onClick = {
                    isSelected = false
                }
            )
            Text(
                text = "Option 2",
                modifier = Modifier.padding(top = 15.dp, end = 15.dp)
            )
        }
    }
}

@Composable
fun RadioButtonSample2(){
    val items=listOf("Calls","Missed","Friends")
    var selectedIndex by remember { mutableIntStateOf(0) }
    Column(
        modifier = Modifier.selectableGroup()
    ) {

        items.forEachIndexed { index, string ->
            Row {
                val isSelected = selectedIndex == index
                RadioButton(
                    selected = isSelected,
                    onClick = {
                        selectedIndex = index
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Green,
                        unselectedColor = Color.Red
                    )
                )
                Text(
                    text = string,
                    modifier = Modifier.padding(top = 15.dp, end = 15.dp),
                    color = if(isSelected) Color.Green else Color.Red
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun RadioButtonSamplePreview(){
    RadioButtonSample2()
}