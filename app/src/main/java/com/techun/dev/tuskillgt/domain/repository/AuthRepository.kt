package com.techun.dev.tuskillgt.domain.repository

import com.techun.dev.tuskillgt.domain.model.LoginResult
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun insertUser(user: String, password: String)
    suspend fun doLogin(user: String, password: String): LoginResult
    suspend fun doLogout()
    val isFirstLaunch: Flow<Boolean>
    suspend fun setFirstLaunchCompleted()
    val isAuthenticated: Flow<Boolean>
    suspend fun setAuthenticated(isAuthenticated: Boolean)
}