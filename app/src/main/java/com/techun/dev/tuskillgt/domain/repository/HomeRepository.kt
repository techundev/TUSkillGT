package com.techun.dev.tuskillgt.domain.repository

import com.techun.dev.tuskillgt.domain.model.DataHome

interface HomeRepository {
    suspend fun loadHomeInfo(): DataHome
}