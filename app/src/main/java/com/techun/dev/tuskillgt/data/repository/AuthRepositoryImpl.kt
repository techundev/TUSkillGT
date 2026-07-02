package com.techun.dev.tuskillgt.data.repository

import com.techun.dev.tuskillgt.data.local.dao.AuthDao
import com.techun.dev.tuskillgt.data.local.entity.UserEntity
import com.techun.dev.tuskillgt.data.local.preferences.AppPreferencesDataSource
import com.techun.dev.tuskillgt.domain.model.LoginResult
import com.techun.dev.tuskillgt.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow


class AuthRepositoryImpl(
    private val dao: AuthDao, private val preferencesDataSource: AppPreferencesDataSource
) : AuthRepository {
    override suspend fun insertUser(user: String, password: String) {
        dao.insertUser(UserEntity(user = user, password = password))
    }

    override suspend fun doLogin(
        user: String,
        password: String
    ): LoginResult {
        return try {
            val roomResponse = dao.doLogin(user, password)
            if (roomResponse != null) {
                LoginResult.Success
            } else {
                LoginResult.InvalidCredentials
            }
        } catch (e: Exception) {
            LoginResult.Error(e.message ?: "Error desconocido al iniciar sesión")
        }
    }

    override suspend fun doLogout() {
        preferencesDataSource.setAuthenticated(false)
    }

    override val isFirstLaunch: Flow<Boolean> = preferencesDataSource.isFirstLaunch

    override suspend fun setFirstLaunchCompleted() {
        preferencesDataSource.setFirstLaunchCompleted()
    }

    override val isAuthenticated: Flow<Boolean> = preferencesDataSource.isAuthenticated

    override suspend fun setAuthenticated(isAuthenticated: Boolean) {
        preferencesDataSource.setAuthenticated(isAuthenticated)
    }
}