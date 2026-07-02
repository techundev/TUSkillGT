package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.domain.model.SplashDestination
import com.techun.dev.tuskillgt.domain.repository.AuthRepository
import kotlinx.coroutines.flow.first

class GetSplashDestinationUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(): SplashDestination {
        val isAuthenticated = authRepository.isAuthenticated.first()
        return if (isAuthenticated) SplashDestination.Home else SplashDestination.Login
    }
}