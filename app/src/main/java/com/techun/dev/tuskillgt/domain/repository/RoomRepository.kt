package com.techun.dev.tuskillgt.domain.repository

import com.techun.dev.tuskillgt.domain.model.LoginResult
import kotlinx.coroutines.flow.Flow

interface RoomRepository {
    suspend fun insertUser(user: String, password: String)
    val isFirstLaunch: Flow<Boolean>
    suspend fun setFirstLaunchCompleted()
    suspend fun doLogin(user: String, password: String): LoginResult
}