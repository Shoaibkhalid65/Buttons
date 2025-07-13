package com.example.buttons.buttonGroups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ButtonGroup
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun Sample1(){
        ButtonGroup(
            overflowIndicator = { menuState ->
                IconButton(
                    onClick = {
                        if (menuState.isExpanded) {
                            menuState.dismiss()
                        } else {
                            menuState.show()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "overflow icon"
                    )
                }
            },
            expandedRatio =1f,
            horizontalArrangement = Arrangement.SpaceBetween

            ) {
            repeat(50) { i ->
                clickableItem(
                    onClick = {},
                    label = "$i"
                )
            }


        }
    }
@Preview(
    showBackground = true,
    device = "spec:width=360dp,height=640dp,dpi=320,navigation=gesture"
)
@Composable
fun Sample1Preview(){
    Sample1()
}