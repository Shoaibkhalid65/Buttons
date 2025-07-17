package com.example.buttons.buttonGroups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ButtonGroup
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buttons.ui.theme.BlueContainerColor
import com.example.buttons.ui.theme.BlueTextColor
import com.example.buttons.ui.theme.LightBlueContainerColor

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
@Preview(showBackground = true)
fun CustomMultiSelectButtonGroup(){
    val texts=listOf("8 oz","12 oz","16 oz","20 oz")
    val selected= remember{ mutableStateListOf(false,false,false,false) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(ButtonGroupDefaults.ConnectedSpaceBetween),
        verticalAlignment = Alignment.CenterVertically
    ) {
        texts.forEachIndexed { index, string ->
            ToggleButton(
                checked = selected[index],
                onCheckedChange = {
                    selected[index]=it
                },
                shapes =
                    when(index){
                        0 -> ButtonGroupDefaults.connectedLeadingButtonShapes()
                        texts.size-1 -> ButtonGroupDefaults.connectedTrailingButtonShapes()
                        else -> ButtonGroupDefaults.connectedMiddleButtonShapes()
                    },
                colors = ToggleButtonDefaults.toggleButtonColors(
                    containerColor = LightBlueContainerColor,
                    contentColor = BlueTextColor,
                    checkedContainerColor = BlueContainerColor,
                    checkedContentColor = Color.White
                )
            ) {
                if(selected[index]){
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        modifier = Modifier.size(ToggleButtonDefaults.IconSize)
                    )
                    Spacer(modifier = Modifier.size(ToggleButtonDefaults.IconSpacing))
                }
                Text(
                    text = string,
                )


            }
        }
    }
    }
}