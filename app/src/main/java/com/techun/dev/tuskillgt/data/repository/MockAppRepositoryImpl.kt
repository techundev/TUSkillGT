package com.techun.dev.tuskillgt.data.repository

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import com.techun.dev.tuskillgt.core.utils.chef_hat
import com.techun.dev.tuskillgt.core.utils.computer_sound
import com.techun.dev.tuskillgt.core.utils.health_and_beauty
import com.techun.dev.tuskillgt.core.utils.imagesmode
import com.techun.dev.tuskillgt.core.utils.precision_manufacturing
import com.techun.dev.tuskillgt.domain.model.AboutUsData
import com.techun.dev.tuskillgt.domain.model.CompetenciesData
import com.techun.dev.tuskillgt.domain.model.ContactData
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

    override suspend fun loadCompetenciesInfo() = listOf(
        CompetenciesData(
            icon = computer_sound,
            title = "Tecnología de la Información",
            description = "Desarrollo de software, redes y soporte técnico."
        ),
        CompetenciesData(
            icon = precision_manufacturing,
            title = "Mecatrónica",
            description = "Integración de sistemas mecánicos, electrónicos y de control."
        ),
        CompetenciesData(
            icon = health_and_beauty,
            title = "Estética y Belleza",
            description = "Técnicas de maquillaje, cuidado de la piel y estilismo."
        ),
        CompetenciesData(
            icon = chef_hat,
            title = "Cocina y Gastronomía",
            description = "Preparación culinaria, presentación y creatividad gastronómica."
        ),
        CompetenciesData(
            icon = imagesmode,
            title = "Diseño Gráfico",
            description = "Comunicación visual, diseño digital y creatividad aplicada."
        )
    )

    override suspend fun loadContactInfo() = ContactData(
        title = "Participación y Contacto",
        requiredTile = "Requisitos para participar",
        requireDescription = "* Ser guatemalteco(a) entre 17 y 25 años.\n* Estar inscrito en una institución educativa o técnica.\n* Tener interés en alguna de las competencias.",
        processTitle = "Proceso de inscripción",
        processDescription = "1. Completa el formulario en línea.\n2. Participa en las pruebas de selección.\n3. Prepárate con expertos y entrena para competir.",
        importantDateTitle = "Fechas importantes",
        importantDateDescription = "* Convocatoria: Julio\n* Pruebas de selección: Agosto\n* Entrenamientos: Septiembre-Octubre",
        contactTitle = "Contacto",
        emailIcon = Icons.Filled.Email,
        email = "contacto@worldskills.gt",
        phoneIcon = Icons.Filled.Phone,
        phoneNumber = "+502 1234 5678"
    )
}