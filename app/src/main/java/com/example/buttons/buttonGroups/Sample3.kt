package com.example.buttons.buttonGroups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun MultiSelectConnectedButtonGroupSample(){
    val isChecked= remember{mutableStateListOf(false,false,false,false,false)}
    FlowRow (
        modifier = Modifier.padding(horizontal = 8.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(ButtonGroupDefaults.ConnectedSpaceBetween)
    ) {
        Item1.entries.forEachIndexed { index,item1 ->
            ToggleButton(
                checked = isChecked[index],
                onCheckedChange = {
                    isChecked[index]=it
                },
//                modifier = Modifier.weight(item1.weight),
                shapes = when(item1.ordinal){
                    0-> ButtonGroupDefaults.connectedLeadingButtonShapes()
                    Item1.entries.size-1-> ButtonGroupDefaults.connectedTrailingButtonShapes()
                    else -> ButtonGroupDefaults.connectedMiddleButtonShapes()
                },
                colors = ToggleButtonDefaults.toggleButtonColors(
                    containerColor = Color.Red,
                    contentColor = Color.Black,
                    checkedContainerColor = Color.Green,
                    checkedContentColor = Color.White
                )
            ) {
                Icon(
                    imageVector = if(isChecked[index]) item1.selectedIcon else item1.unSelectedIcon,
                    contentDescription = "item icon"
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    text = item1.label
                )

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MultiSelectConnectedButtonGroupSamplePreview(){
    MultiSelectConnectedButtonGroupSample()
}