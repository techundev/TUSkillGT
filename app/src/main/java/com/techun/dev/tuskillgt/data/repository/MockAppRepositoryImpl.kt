package com.techun.dev.tuskillgt.data.repository

import com.techun.dev.tuskillgt.domain.model.AboutUsData
import com.techun.dev.tuskillgt.domain.model.HomeData
import com.techun.dev.tuskillgt.domain.repository.MockAppRepository

class MockAppRepositoryImpl : MockAppRepository {
    override suspend fun loadHomeInfo() = HomeData(
        title = "Bienvenido a SkillGT",
        description = "Conoce el movimiento que impulsa la excelencia en habilidades técnicas y tecnológicas en Guatemala."
    )

    override suspend fun loadAboutUsInfo() = AboutUsData(
        title = "¿Qué es WorldSkills Guatemala?",
        worldWideTitle = "Historia de WorldSkills",
        worldWideDescription = "WorldSkills es una organización internacional que promueve la excelencia en habilidades técnicas y vocacionales desde 1950, conectando a jóvenes de todo el mundo a través de competencias de alto nivel.",
        localTitle = "WorldSkills Guatemala",
        localDescription = "WorldSkills Guatemala forma parte de este movimiento global, brindando oportunidades a jóvenes guatemaltecos para desarrollar su talento, competir internacionalmente y transformar su futuro profesional.",
        slogan = "\"Las habilidades construyen el futuro. El talento transforma naciones.\""
    )
}