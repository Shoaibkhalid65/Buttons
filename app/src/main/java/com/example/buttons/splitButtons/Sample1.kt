package com.example.buttons.splitButtons

import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.SplitButtonDefaults
import androidx.compose.material3.SplitButtonLayout
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SplitButtonSample1(){
    val size= SplitButtonDefaults.MediumContainerHeight
    SplitButtonLayout(
        leadingButton =
            {
                SplitButtonDefaults.LeadingButton(
                    onClick = {},
                    modifier = Modifier.heightIn(size),
                    shapes = SplitButtonDefaults.leadingButtonShapesFor(size)
                ) {
                    Text(
                        text = "Button",
                    )
                }
            }
        ,
        trailingButton =
            {

               SplitButtonDefaults.TrailingButton(
                   onClick = {},
                   modifier = Modifier.heightIn(size)
               ) {
                   Text(
                       text = "Button 2"
                   )
               }
            },
        modifier = Modifier,
        spacing = SplitButtonDefaults.Spacing
    )
}

@Preview
@Composable
fun SplitButtonSamplePreview(){
    SplitButtonSample1()
}