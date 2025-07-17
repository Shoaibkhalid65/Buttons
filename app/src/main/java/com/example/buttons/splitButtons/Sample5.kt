package com.example.buttons.splitButtons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.SplitButtonDefaults
import androidx.compose.material3.SplitButtonLayout
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Flat
import com.gandiva.neumorphic.shape.Pressed
import com.gandiva.neumorphic.shape.RoundedCorner

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
@Preview
fun SplitButtonSample5() {
    Box(modifier = Modifier
        .background(Color(0xFFDCDCDC))
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        var isChecked by remember { mutableStateOf(false) }
        val size = SplitButtonDefaults.ExtraSmallContainerHeight
        SplitButtonLayout(
            leadingButton = {
                SplitButtonDefaults.ElevatedLeadingButton(
                    onClick = {},
                    modifier = Modifier.heightIn(size),
                    shapes = SplitButtonDefaults.leadingButtonShapesFor(size),
                    contentPadding = SplitButtonDefaults.leadingButtonContentPaddingFor(size),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = Color(0xFFDCDCDC)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        modifier = Modifier.size(SplitButtonDefaults.leadingButtonIconSizeFor(size))
                    )
                    Spacer(modifier = Modifier.size(ButtonDefaults.iconSpacingFor(size)))
                    Text(
                        text = "Settings",
                        style = ButtonDefaults.textStyleFor(size)
                    )
                }
            },
            trailingButton = {
                SplitButtonDefaults.ElevatedTrailingButton(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = it
                    },
                    modifier = Modifier.heightIn(size),
                    shapes = SplitButtonDefaults.trailingButtonShapesFor(size),
                    contentPadding = SplitButtonDefaults.trailingButtonContentPaddingFor(size),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = Color(0xFFDCDCDC)
                    )
                ) {
                    val rotation by animateFloatAsState(
                        targetValue = if (isChecked) 180f else 0f,
                        label = "animate the trailing icon"
                    )
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier
                            .size(SplitButtonDefaults.trailingButtonIconSizeFor(size))
                            .graphicsLayer(
                                rotationZ = rotation
                            )
                    )
                }
            },
            modifier = Modifier.neu(
                lightShadowColor = Color(0xFFFFFFFF),
                darkShadowColor = Color(0xFFA8B5C7),
                shadowElevation = 12.dp,
                shape = Pressed(RoundedCorner(32.dp)),
                lightSource = if(isChecked)LightSource.LEFT_BOTTOM else LightSource.RIGHT_TOP
            )

        )
    }
}


