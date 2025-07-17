package com.example.buttons.splitButtons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector


enum class MenuItem1(
    val leadingVector: ImageVector,
    val text: String,
    val trailingText: String?=null
){
    EDIT(
        leadingVector = Icons.Outlined.Edit,
        text = "Edit"
    ),
    SETTINGS(
        leadingVector = Icons.Outlined.Settings,
        text = "Settings"
    ),
    FEEDBACK(
        leadingVector = Icons.Outlined.Mail,
        text = "Send Feedback",
        trailingText = "F11"
    )
}