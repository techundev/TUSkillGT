package com.techun.dev.tuskillgt.ui.contact

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.techun.dev.tuskillgt.R
import com.techun.dev.tuskillgt.core.composables.TUSkillGTButton
import com.techun.dev.tuskillgt.core.composables.TUSkillGTErrorScreen
import com.techun.dev.tuskillgt.core.composables.TUSkillGTLoadingScreen
import com.techun.dev.tuskillgt.core.composables.TUSkillGTText
import com.techun.dev.tuskillgt.domain.model.ContactData
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ContactScreen(viewModel: ContactViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when (val state = uiState) {
                is ContactUiState.Loading -> TUSkillGTLoadingScreen()
                is ContactUiState.Error -> TUSkillGTErrorScreen(state.message)
                is ContactUiState.Success -> ContactContent(state.data)
            }
        }
    }
}

@Composable
fun ContactContent(data: ContactData) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TUSkillGTText(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = data.title,
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(10.dp))
        TUSkillGTText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = data.requiredTile,
            style = MaterialTheme.typography.titleSmall,
        )
        TUSkillGTText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = data.requireDescription,
            style = MaterialTheme.typography.bodyMedium
        )
        TUSkillGTText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = data.processTitle,
            style = MaterialTheme.typography.titleSmall,
        )
        TUSkillGTText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = data.processDescription,
            style = MaterialTheme.typography.bodyMedium
        )
        TUSkillGTText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = data.importantDateTitle,
            style = MaterialTheme.typography.titleSmall,
        )
        TUSkillGTText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = data.importantDateDescription,
            style = MaterialTheme.typography.bodyMedium
        )
        TUSkillGTText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = data.contactTitle,
            style = MaterialTheme.typography.titleSmall,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = data.emailIcon,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            TUSkillGTText(
                modifier = Modifier.fillMaxWidth(),
                text = data.email,
                color = MaterialTheme.colorScheme.primary
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = data.phoneIcon,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            TUSkillGTText(
                modifier = Modifier.fillMaxWidth(), text = data.phoneNumber
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.facebook),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Icon(
                painter = painterResource(R.drawable.twitter),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Icon(
                painter = painterResource(R.drawable.instagram),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        TUSkillGTButton(
            modifier = Modifier.padding(horizontal = 44.dp),
            onclick = {},
            text = "Volver al inicio",
            shape = MaterialTheme.shapes.small
        )
    }
}