package com.example.buttons.buttonGroups

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonGroupDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gandiva.neumorphic.LightSource
import com.gandiva.neumorphic.NeuAttrs
import com.gandiva.neumorphic.shape.Pressed
import com.gandiva.neumorphic.shape.RoundedCorner

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SingleSelectButtonGroup(){
    val neuAttrs= NeuAttrs(
        lightShadowColor =Color(0x66494949),
        darkShadowColor = Color(0x66000000),
        shadowElevation = 12.dp,
        shape = Pressed(RoundedCorner(12.dp)),
        lightSource = LightSource.RIGHT_TOP
    )
    var selectedIndex by remember { mutableIntStateOf(0) }
    FlowRow (
        modifier = Modifier.padding(horizontal = 8.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(space = ButtonGroupDefaults.ConnectedSpaceBetween),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Item1.entries.forEachIndexed { index, item1 ->
            val isSelected=selectedIndex==index
            ToggleButton(
                checked = isSelected,
                onCheckedChange = {
                    selectedIndex=index
                },
                modifier = Modifier
//                    .weight(item1.weight)
                    .semantics{
                        role= Role.RadioButton
                    }

                ,
                shapes = when(index){
                        0-> ButtonGroupDefaults.connectedLeadingButtonShapes()
                        Item1.entries.size-1-> ButtonGroupDefaults.connectedTrailingButtonShapes()
                        else -> ButtonGroupDefaults.connectedMiddleButtonShapes()
                    },


            ) {
                Icon(
                    imageVector = if(isSelected) item1.selectedIcon else item1.unSelectedIcon,
                    contentDescription = "button icon"
                )
                Spacer(modifier = Modifier.size(ToggleButtonDefaults.IconSpacing))
                Text(
                    text = item1.label
                )
            }
        }
    }
}
@Preview()
@Composable
fun SingleSelectButtonGroupPreview(){
    SingleSelectButtonGroup()
}