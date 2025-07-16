package com.example.buttons.buttonGroups

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SegmentedButtonSingleSelectSample1(){
    var selectedIndex by remember { mutableIntStateOf(0) }
    SingleChoiceSegmentedButtonRow {
        Item2.entries.forEachIndexed { index, item2 ->
            val isSelected=selectedIndex==index
            SegmentedButton(
                selected = isSelected,
                onClick = {
                    selectedIndex=index
                },
                shape = SegmentedButtonDefaults.itemShape(
                    index=index,
                    count = Item2.entries.size
                ),
                icon = {
                    SegmentedButtonDefaults.Icon(
                        active = isSelected,
                        activeContent = {
                            Icon(
                              imageVector = Icons.Default.Check,
                              contentDescription = null
                            )
                        }
                    ) {
                        Icon(
                            imageVector = item2.icon,
                            contentDescription = null,
                            modifier = Modifier.size(ToggleButtonDefaults.IconSize)
                        )
                    }
                }
            ) {
                Text(
                    text = item2.label
                )
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun SegmentedButtonSingleSelectSample1Preview(){
    SegmentedButtonSingleSelectSample1()
}