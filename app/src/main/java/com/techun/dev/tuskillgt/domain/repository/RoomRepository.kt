package com.techun.dev.tuskillgt.domain.repository

import com.techun.dev.tuskillgt.domain.model.User

interface RoomRepository {
    suspend fun login(user: User): Boolean
}