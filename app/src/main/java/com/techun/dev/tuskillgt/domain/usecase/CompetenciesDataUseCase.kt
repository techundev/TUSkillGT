package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.domain.model.CompetenciesData
import com.techun.dev.tuskillgt.domain.repository.MockAppRepository

class CompetenciesDataUseCase(private val repository: MockAppRepository) {
    suspend operator fun invoke(): List<CompetenciesData> = repository.loadCompetenciesInfo()
}