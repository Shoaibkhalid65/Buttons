package com.example.buttons.buttonGroups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Alarm
import androidx.compose.material.icons.outlined.Bluetooth
import androidx.compose.material.icons.outlined.FlashlightOn
import androidx.compose.material.icons.outlined.RemoveCircleOutline
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buttons.ui.theme.LightPinkColor
import com.example.buttons.ui.theme.PurpleContainerColor
import com.example.buttons.ui.theme.PurpleIconColor
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
@Preview(showBackground = true)
fun CustomSingleSelectButtonGroup(){
     val vectors=listOf(
         Icons.Outlined.Bluetooth,
         Icons.Outlined.Alarm,
         Icons.Outlined.RemoveCircleOutline,
         Icons.Outlined.FlashlightOn,
         Icons.Outlined.Wifi
     )
    var selectedIndex by remember { mutableIntStateOf(0) }
    val size = 55.dp
    FlowRow (
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.Center,

    ){
        vectors.forEachIndexed { index, vector ->
            val isSelected=selectedIndex==index
            Button(
                onClick = {
                    selectedIndex=index
                },
                shapes = ButtonDefaults.shapes(
                    shape = if(isSelected) RoundedCornerShape(8.dp) else CircleShape,
                    pressedShape = ButtonDefaults.squareShape
                ),
                colors = ButtonDefaults.buttonColors(
                    contentColor = if(isSelected) Color.White else PurpleIconColor,
                    containerColor = if(isSelected) PurpleContainerColor else LightPinkColor
                ),
                contentPadding = ButtonDefaults.contentPaddingFor(size),
                modifier = Modifier.padding(start = 5.dp).heightIn(size)
            ) {
                Icon(
                    imageVector = vector,
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.iconSizeFor(size))
                )
                if(index==2){
                    Spacer(modifier = Modifier.size(ButtonDefaults.iconSizeFor(size)))
                    Text(
                        text = "Focus",
                        style = ButtonDefaults.textStyleFor(size)
                    )
                }
            }
        }
    }
}