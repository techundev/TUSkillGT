package com.techun.dev.tuskillgt.domain.usecase

import com.techun.dev.tuskillgt.domain.model.AboutUsData
import com.techun.dev.tuskillgt.domain.repository.MockAppRepository

class AboutUsUseCase(private val repository: MockAppRepository) {
    suspend operator fun invoke(): AboutUsData = repository.loadAboutUsInfo()
}