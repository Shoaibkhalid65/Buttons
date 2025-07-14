package com.example.buttons.buttonGroups

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Work
import androidx.compose.ui.graphics.vector.ImageVector

enum class Item1(
    val label: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val weight: Float=1f
){
    WORK(
        label = "Work",
        selectedIcon = Icons.Default.Work,
        unSelectedIcon = Icons.Outlined.Work
    ),
    RESTAURANT(
        label = "Restaurant",
        selectedIcon = Icons.Default.Restaurant,
        unSelectedIcon = Icons.Outlined.Restaurant,
        weight = 1.5f
    ),
    COFFEE(
        label = "Coffee",
        selectedIcon = Icons.Default.Coffee,
        unSelectedIcon = Icons.Outlined.Coffee
    ),
    WORK1(
        label = "Work",
        selectedIcon = Icons.Default.Work,
        unSelectedIcon = Icons.Outlined.Work
    ),
    RESTAURANT1(
        label = "Restaurant",
        selectedIcon = Icons.Default.Restaurant,
        unSelectedIcon = Icons.Outlined.Restaurant,
        weight = 1.5f
    ),
    COFFEE1(
        label = "Coffee",
        selectedIcon = Icons.Default.Coffee,
        unSelectedIcon = Icons.Outlined.Coffee
    )
}