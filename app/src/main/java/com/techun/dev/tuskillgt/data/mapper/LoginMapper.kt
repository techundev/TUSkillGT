package com.techun.dev.tuskillgt.data.mapper

import com.techun.dev.tuskillgt.data.local.entity.UserEntity
import com.techun.dev.tuskillgt.domain.model.User

fun User.toEntity() = UserEntity(
    user = user,
    password = password
)