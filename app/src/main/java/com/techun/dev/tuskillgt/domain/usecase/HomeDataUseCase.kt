package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.domain.model.HomeData
import com.techun.dev.tuskillgt.domain.repository.MockAppRepository

class HomeDataUseCase(private val repository: MockAppRepository) {
    suspend operator fun invoke(): HomeData = repository.loadHomeInfo()
}