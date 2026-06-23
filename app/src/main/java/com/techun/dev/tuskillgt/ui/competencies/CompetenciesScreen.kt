package com.techun.dev.tuskillgt.ui.competencies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.techun.dev.tuskillgt.core.composables.TUSkillGTErrorScreen
import com.techun.dev.tuskillgt.core.composables.TUSkillGTLoadingScreen
import com.techun.dev.tuskillgt.core.composables.TUSkillGTText
import com.techun.dev.tuskillgt.domain.model.CompetenciesData
import com.techun.dev.tuskillgt.ui.competencies.composables.TUSkillGTCardCompetencies
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CompetenciesScreen(viewModel: CompetenciesViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (val state = uiState) {
                is CompetenciesUiState.Loading -> TUSkillGTLoadingScreen()
                is CompetenciesUiState.Error -> TUSkillGTErrorScreen(state.message)
                is CompetenciesUiState.Success -> CompetenciesContent(state.data)
            }
        }
    }
}

@Composable
fun CompetenciesContent(data: List<CompetenciesData>) {
    LazyColumn(
        //contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(25.dp)
            ) {
                TUSkillGTText(
                    text = "Categorías y Competencias",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White
                )
            }
        }

        items(
            items = data,
            key = { it.title }
        ) { competencies ->
            TUSkillGTCardCompetencies(
                item = competencies,
                onClick = {}
            )
        }
    }
}