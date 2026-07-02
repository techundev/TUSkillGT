package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.domain.repository.AuthRepository
import kotlinx.coroutines.flow.first

class InitializeDefaultUserUseCase(private val authRepository: AuthRepository) {
    companion object {
        private const val DEFAULT_USER = "admin"
        private const val DEFAULT_PASSWORD = "1234"
    }

    suspend operator fun invoke() {
        val isFirstLaunch = authRepository.isFirstLaunch.first()
        if (isFirstLaunch) {
            authRepository.insertUser(DEFAULT_USER, DEFAULT_PASSWORD)
            authRepository.setFirstLaunchCompleted()
        }
    }
}