package com.techun.dev.tuskillgt.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

data class ContactData(
    val title: String,
    val requiredTile: String,
    val requireDescription: String,
    val processTitle: String,
    val processDescription: String,
    val importantDateTitle: String,
    val importantDateDescription: String,
    val contactTitle: String,
    val emailIcon: ImageVector,
    val email: String,
    val phoneIcon: ImageVector,
    val phoneNumber: String
)
