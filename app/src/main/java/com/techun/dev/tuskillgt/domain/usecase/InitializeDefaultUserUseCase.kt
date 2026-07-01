package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.domain.repository.RoomRepository
import kotlinx.coroutines.flow.first

class InitializeDefaultUserUseCase(private val roomRepository: RoomRepository) {
    companion object {
        private const val DEFAULT_USER = "asantos"
        private const val DEFAULT_PASSWORD = "1234567890"
    }

    suspend operator fun invoke() {
        val isFirstLaunch = roomRepository.isFirstLaunch.first()
        if (isFirstLaunch) {
            roomRepository.insertUser(DEFAULT_USER, DEFAULT_PASSWORD)
            roomRepository.setFirstLaunchCompleted()
        }
    }
}