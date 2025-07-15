package com.example.buttons.buttonGroups

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SegmentedButtonMultiSelectSample(){
     val checkList = remember { mutableStateListOf(false,false,false) }
    MultiChoiceSegmentedButtonRow {
        Item2.entries.forEachIndexed { index, item2 ->
            SegmentedButton(
                checked = checkList[index],
                onCheckedChange = {
                    checkList[index]=it
                },
                shape = SegmentedButtonDefaults.itemShape(
                    index=index,
                    count = Item2.entries.size,
                    baseShape = SegmentedButtonDefaults.baseShape
                ),
                icon ={ SegmentedButtonDefaults.Icon(
                    active = checkList[index],
                )
                {
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
fun SegmentedButtonMultiSelectSamplePreview(){
    SegmentedButtonMultiSelectSample()
}