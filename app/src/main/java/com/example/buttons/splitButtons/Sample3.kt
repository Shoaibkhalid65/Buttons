package com.example.buttons.splitButtons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.SplitButtonDefaults
import androidx.compose.material3.SplitButtonLayout
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
@Preview
fun TonalSplitButtonSample(){
    var isChecked by remember { mutableStateOf(false) }
    SplitButtonLayout(
        leadingButton = {
            SplitButtonDefaults.TonalLeadingButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "leading button icon",
                    modifier = Modifier.size(SplitButtonDefaults.LeadingIconSize)
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    text = "My Button"
                )
            }
        },
        trailingButton = {
            SplitButtonDefaults.TonalTrailingButton(
                checked = isChecked,
                onCheckedChange = {
                    isChecked=it
                }
            ) {
                val rotation by animateFloatAsState(
                    targetValue = if(isChecked) 180f else 0f,
                    label = "toggle button"
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier
                        .size(SplitButtonDefaults.TrailingIconSize)
                        .graphicsLayer(
                            rotationZ = rotation
                        )
                )
            }
        }
    )
    DropdownMenu(
        expanded = isChecked,
        onDismissRequest = {
            isChecked=false
        }
    ) {
        MenuItem1.entries.forEachIndexed { index, item ->
            DropdownMenuItem(
                text = {
                    Text(
                        text = item.text
                    )
                },
                onClick = {
                    isChecked=false
                },
                leadingIcon = {
                    Icon(
                        imageVector = item.leadingVector,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    item.trailingText?.let {
                        Text(
                            text = item.trailingText,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            )
            if(index==1){
                HorizontalDivider()
            }
        }
    }
}