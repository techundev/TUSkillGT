package com.techun.dev.tuskillgt.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.techun.dev.tuskillgt.data.local.dao.AuthDao
import com.techun.dev.tuskillgt.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AuthDatabase : RoomDatabase() {
    abstract fun authDao(): AuthDao
}