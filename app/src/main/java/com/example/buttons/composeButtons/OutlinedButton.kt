package com.example.buttons.composeButtons

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.LockReset
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButtonShapes
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.OutlinedToggleButton
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.RoundedBitmapDrawable

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun OutlinedButtonSample(){
    OutlinedButton(
        onClick = {},
        shapes = ButtonDefaults.shapes()
    ) {
        Text(
            text = "Outlined Button"
        )
    }

}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun OutlinedIconButtonSample(){
    OutlinedIconButton(
        onClick = {},
        shape = IconButtonDefaults.largeRoundShape,
        modifier = Modifier.size(IconButtonDefaults.largeContainerSize())
    ) {
        Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun OutlinedIconToggleButtonSample(){
    var checked by remember { mutableStateOf(false) }
    OutlinedIconToggleButton(
        checked = checked,
        onCheckedChange = {
            checked=it
        },
        shapes = IconToggleButtonShapes(
            shape = CircleShape,
            pressedShape = RoundedCornerShape(4.dp),
            checkedShape = ButtonDefaults.squareShape
        )
    ) {
        Icon(
            imageVector = if(checked)Icons.Default.Lock else Icons.Outlined.Lock,
            contentDescription = null
        )
    }
}


@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun OutlinedToggleButtonSample(){
    var checked by remember { mutableStateOf(false) }
    OutlinedToggleButton(
        checked =checked,
        onCheckedChange = {
            checked=it
        }
    ) {
        Text(
            text = "Outlined toggle button"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedButtonSamplePreview(){
    OutlinedToggleButtonSample()
}