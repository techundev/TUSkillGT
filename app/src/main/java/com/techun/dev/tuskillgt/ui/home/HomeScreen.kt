package com.techun.dev.tuskillgt.ui.home

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
import com.techun.dev.tuskillgt.core.composables.TUSkillGTText
import com.techun.dev.tuskillgt.domain.model.DataHome
import com.techun.dev.tuskillgt.ui.home.composables.HomeError
import com.techun.dev.tuskillgt.ui.home.composables.HomeLoading
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (val state = uiState) {
                is HomeUiState.Loading -> HomeLoading()
                is HomeUiState.Error -> HomeError(message = state.message)
                is HomeUiState.Success -> HomeContent(data = state.data)
            }
        }
    }
}


@Composable
private fun HomeContent(data: DataHome) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 44.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.wskills_guatemala),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        TUSkillGTText(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = data.title,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(30.dp))
        TUSkillGTText(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = data.description,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(30.dp))
        TUSkillGTButton(onclick = {}, text = "Ingresar", shape = MaterialTheme.shapes.small)
    }
}