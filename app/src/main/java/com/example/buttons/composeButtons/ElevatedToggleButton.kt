package com.example.buttons.composeButtons



import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Egg
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.RoundedCorner
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Egg
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedToggleButton
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconButtonShapes
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buttons.R
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.neu
import com.gandiva.neumorphic.shape.Flat
import com.gandiva.neumorphic.shape.Pressed
import com.gandiva.neumorphic.shape.RoundedCorner

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ElevatedToggleButtonSample(){
    var isChecked by remember { mutableStateOf(false) }
    ElevatedToggleButton(
        checked = isChecked,
        onCheckedChange = {
            isChecked=it
        },
        shapes = ToggleButtonDefaults.shapes(

        )
    ) {
        Text(
            "elevated toggle button"
        )
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FilledIconButtonSample(){
    FilledIconButton(
        onClick = {},
        shapes = IconButtonDefaults.shapes(),
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = Color.Red,
            contentColor = Color.White
        ),

    ) {
        Icon(
            imageVector = Icons.Default.Coffee,
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FilledIconToggleButtonSample(){
    var checked by remember { mutableStateOf(false) }
    FilledIconToggleButton(
        checked = checked,
        onCheckedChange = {checked=it},
        shapes = IconButtonDefaults.toggleableShapes()
    ) {
        Image(
            imageVector = if(checked)Icons.Default.Egg else Icons.Outlined.Egg,
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FilledTonalButtonSample(){
    FilledTonalButton(
        onClick = {},
        shapes = ButtonDefaults.shapes()
    ) {
        Text(
            text = "Filled tonal button"
        )
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FilledTonalIconButtonSample(){
    FilledTonalIconButton(
        onClick = {},
        shapes = IconButtonDefaults.shapes()
    ) {
         Icon(
             imageVector = Icons.Default.Favorite,
             contentDescription = null
         )
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun FilledTonalIconToggleButtonSample(){
    var checked by remember { mutableStateOf(false) }
    FilledTonalIconToggleButton(
        checked = checked,
        onCheckedChange = {
            checked=it
        },
        colors = IconButtonDefaults.filledIconToggleButtonColors(
            containerColor =Color(0xFFDCDCDC),
            checkedContainerColor = Color(0xFFDCDCDC),
            checkedContentColor = Color.Magenta,
            contentColor = Color.Green
        ),
        modifier = Modifier
            .neu(
                lightShadowColor = Color(0xFFFFFFFF),
                darkShadowColor = Color(0xFFA8B5C7),
                shadowElevation = 12.dp,
                shape = Pressed(RoundedCorner(24.dp)),
                lightSource = if(checked)LightSource.LEFT_TOP else LightSource.LEFT_BOTTOM
            )
    ) {
        Icon(
            imageVector = if(checked)Icons.Default.Settings else Icons.Outlined.Settings,
            contentDescription = null
        )
    }
}

@Preview(showBackground = true, backgroundColor =0xFFDCDCDC )
@Composable
fun  ElevatedToggleButtonSamplePreview(){
    FilledTonalIconToggleButtonSample()
}