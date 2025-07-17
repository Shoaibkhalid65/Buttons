package com.example.buttons.splitButtons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.SplitButtonDefaults
import androidx.compose.material3.SplitButtonLayout
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buttons.ui.theme.LightGreenColor
import java.nio.file.WatchEvent

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
@Preview
fun CustomSplitButton(){
    var isChecked by remember { mutableStateOf(false) }
    val texts= listOf("Create New Role","Create New User","Connect New Page")
    var buttonText by remember { mutableStateOf(texts[0]) }
    val size = SplitButtonDefaults.MediumContainerHeight
    var buttonWidth by remember { mutableIntStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ){
        SplitButtonLayout(
            modifier = Modifier.onGloballyPositioned { layoutCoordinates ->
                 buttonWidth=layoutCoordinates.size.width
            },
            leadingButton = {
                SplitButtonDefaults.LeadingButton(
                    onClick = {},
                    modifier = Modifier.heightIn(size),
                    shapes = SplitButtonDefaults.leadingButtonShapesFor(size),
                    contentPadding = SplitButtonDefaults.leadingButtonContentPaddingFor(size),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightGreenColor,
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = buttonText,
                        style = ButtonDefaults.textStyleFor(size)
                    )
                }
            },
            trailingButton = {
                SplitButtonDefaults.TrailingButton(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked=it
                    },
                    modifier = Modifier.heightIn(size),
                    shapes = SplitButtonDefaults.trailingButtonShapesFor(size),
                    contentPadding = SplitButtonDefaults.trailingButtonContentPaddingFor(size),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = LightGreenColor,
                        contentColor = Color.Black

                    )
                ) {
                    val rotation by animateFloatAsState(
                        targetValue = if(isChecked) 180f else 0f,
                        label = "toggle button"
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        modifier = Modifier
                            .size(SplitButtonDefaults.trailingButtonIconSizeFor(size))
                            .graphicsLayer(
                                rotationZ = rotation
                            )
                    )
                }
            },
        )
        DropdownMenu(
            expanded = isChecked,
            onDismissRequest = {
                isChecked=false
            },
            modifier = Modifier.widthIn(with(LocalDensity.current){buttonWidth.toDp()}).padding(start = 15.dp)
        ) {
            var selectedIndex by remember { mutableIntStateOf(0) }
            texts.forEachIndexed { index, string ->
                val isSelected = selectedIndex==index
                DropdownMenuItem(
                    text = {
                        Text(
                            text=string,
                            fontWeight = if(isSelected) FontWeight.Medium else FontWeight.Normal,
                            style = ButtonDefaults.textStyleFor(size)
                        )
                    },
                    onClick = {
                        selectedIndex=index
                        buttonText=texts[index]
                    },
                    trailingIcon = {
                        if(isSelected){
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        }
    }
}