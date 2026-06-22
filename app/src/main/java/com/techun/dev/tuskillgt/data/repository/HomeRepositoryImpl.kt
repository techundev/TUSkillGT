package com.techun.dev.tuskillgt.data.repository

import com.techun.dev.tuskillgt.domain.model.DataHome
import com.techun.dev.tuskillgt.domain.repository.HomeRepository

class HomeRepositoryImpl : HomeRepository {
    override suspend fun loadHomeInfo() = DataHome(
        title = "Bienvenido a SkillGT",
        description = "Conoce el movimiento que impulsa la excelencia en habilidades técnicas y tecnológicas en Guatemala."
    )
}