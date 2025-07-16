package com.example.buttons.buttonGroups

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.Work
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Work
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector

enum class Item1(
    val label: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val weight: Float=1f,
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
enum class Item2(
    val label:String,
    val icon: ImageVector,
    val weight:Float=1f
){
    FAVORITES(
        label = "Favorites",
        icon = Icons.Filled.StarBorder
    ),
    TRENDING(
        label = "Trending",
        icon = Icons.AutoMirrored.Filled.TrendingUp,
        weight = 2f
    ),
    SAVED(
        label = "Saved",
        icon = Icons.Filled.BookmarkBorder
    )

}
