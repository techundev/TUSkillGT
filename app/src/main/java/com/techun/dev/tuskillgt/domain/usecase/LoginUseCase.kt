package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.data.mapper.toEntity
import com.techun.dev.tuskillgt.domain.model.User
import com.techun.dev.tuskillgt.domain.repository.RoomRepository

class LoginUseCase(private val repository: RoomRepository) {
    suspend operator fun invoke(user: String, password: String): Boolean =
        repository.doLogin(User(user, password).toEntity())
}