package com.techun.dev.tuskillgt.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val user: String? = null,
    val password: String? = null
)
