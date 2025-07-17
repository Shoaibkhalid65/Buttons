package com.example.buttons.buttonGroups

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Subscriptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.buttons.ui.theme.Pink40
import com.example.buttons.ui.theme.Pink80
import com.example.buttons.ui.theme.Purple40
import com.example.buttons.ui.theme.Purple80
import com.example.buttons.ui.theme.PurpleGrey40
import com.example.buttons.ui.theme.PurpleGrey80

@Composable
@Preview(showBackground = true)
fun CustomSegmentedButton(){

    val items=listOf(
        "Settings" to Icons.Outlined.Settings,
        "Dashboard" to Icons.Outlined.Dashboard,
        "Analytics" to Icons.Outlined.Analytics
    )
    val selected = remember { mutableStateListOf<Int>() }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
    MultiChoiceSegmentedButtonRow {
        items.forEachIndexed { index, (string,vector) ->
            SegmentedButton(
                checked = index in selected,
                onCheckedChange = {
                    if(index in selected){
                        selected.remove(index)
                    }else{
                        selected.add(index)
                    }
                },
                shape = SegmentedButtonDefaults.itemShape(
                    index=index,
                    count = items.size,
                    baseShape = SegmentedButtonDefaults.baseShape
                ),
                colors = SegmentedButtonDefaults.colors(
//                    activeContainerColor = Purple40,
//                    activeContentColor = Pink40,
//                    activeBorderColor = PurpleGrey40,
//                    inactiveContainerColor = Purple80,
//                    inactiveContentColor = Pink80,
//                    inactiveBorderColor = PurpleGrey80
                ),
                icon = {
                    SegmentedButtonDefaults.Icon(
                        active = index in selected
                    ) {
                        Icon(
                            imageVector = vector,
                            contentDescription = null
                        )
                    }
                }
            ) {
                Text(
                    text = string
                )
            }
        }
    }
    }
}