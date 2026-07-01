package com.techun.dev.tuskillgt.domain.repository

import com.techun.dev.tuskillgt.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface RoomRepository {
    suspend fun insertUser(user: String, password: String)
    val isFirstLaunch: Flow<Boolean>
    suspend fun setFirstLaunchCompleted()
    suspend fun doLogin(user: UserEntity): Boolean
}