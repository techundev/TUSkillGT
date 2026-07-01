package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.domain.model.User
import com.techun.dev.tuskillgt.domain.repository.RoomRepository

class LoginUseCase(private val repository: RoomRepository) {
    suspend operator fun invoke(user: User): Boolean = repository.login(user)
}