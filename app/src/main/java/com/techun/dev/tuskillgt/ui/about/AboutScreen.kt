package com.techun.dev.tuskillgt.ui.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.techun.dev.tuskillgt.R
import com.techun.dev.tuskillgt.core.composables.TUSkillGTButton
import com.techun.dev.tuskillgt.core.composables.TUSkillGTErrorScreen
import com.techun.dev.tuskillgt.core.composables.TUSkillGTLoadingScreen
import com.techun.dev.tuskillgt.core.composables.TUSkillGTText
import com.techun.dev.tuskillgt.domain.model.AboutUsData
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AboutScreen(viewModel: AboutViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (val state = uiState) {
                is AboutUiState.Loading -> TUSkillGTLoadingScreen()
                is AboutUiState.Error -> TUSkillGTErrorScreen(state.message)
                is AboutUiState.Success -> AboutContent(state.data)
            }
        }
    }
}

@Composable
private fun AboutContent(
    data: AboutUsData
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TUSkillGTText(
            text = data.title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(horizontal = 44.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TUSkillGTText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
            text = data.worldWideTitle,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        TUSkillGTText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
            text = data.worldWideDescription,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        TUSkillGTText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
            text = data.localTitle,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
        TUSkillGTText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
            text = data.localDescription,
            style = MaterialTheme.typography.bodyMedium
        )
        Image(
            modifier = Modifier
                .size(200.dp)
                .padding(horizontal = 44.dp),
            painter = painterResource(R.drawable.wskills_guatemala),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        TUSkillGTText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
            text = data.slogan,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelSmall
        )
        Spacer(modifier = Modifier.height(10.dp))
        TUSkillGTButton(
            modifier = Modifier.padding(horizontal = 44.dp),
            onclick = {},
            text = "Volver al menu",
            shape = MaterialTheme.shapes.small
        )
    }
}