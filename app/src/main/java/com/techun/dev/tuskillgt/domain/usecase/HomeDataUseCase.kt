package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.domain.model.DataHome
import com.techun.dev.tuskillgt.domain.repository.HomeRepository

class HomeDataUseCase(private val repository: HomeRepository) {
    suspend operator fun invoke(): DataHome = repository.loadHomeInfo()
}