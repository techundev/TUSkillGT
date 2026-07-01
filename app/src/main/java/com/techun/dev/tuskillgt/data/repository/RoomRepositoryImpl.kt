package com.techun.dev.tuskillgt.data.repository

import com.techun.dev.tuskillgt.domain.model.User
import com.techun.dev.tuskillgt.domain.repository.RoomRepository

class RoomRepositoryImpl : RoomRepository {
    override suspend fun login(user: User): Boolean {
        return true
    }
}