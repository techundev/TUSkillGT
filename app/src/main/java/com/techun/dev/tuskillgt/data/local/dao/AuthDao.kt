package com.techun.dev.tuskillgt.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.techun.dev.tuskillgt.data.local.entity.UserEntity

@Dao
interface AuthDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM Users WHERE user = :user AND password = :password LIMIT 1")
    suspend fun doLogin(user: String, password: String): UserEntity?
}