package com.example.buttons.buttonGroups

import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview(showBackground = true)
fun CustomSegmentedButton1(){
    val items=listOf("Daily","Weekly","Monthly")
    var selectedIndex by remember { mutableIntStateOf(0) }
    SingleChoiceSegmentedButtonRow {
        items.forEachIndexed { index, string ->
            val isSelected =selectedIndex==index
            SegmentedButton(
                selected = isSelected,
                onClick = {
                    selectedIndex=index
                },
                shape = SegmentedButtonDefaults.itemShape(
                    index=index,
                    count = items.size
                )
            ) {
                Text(
                    text = string
                )
            }
        }
    }

}