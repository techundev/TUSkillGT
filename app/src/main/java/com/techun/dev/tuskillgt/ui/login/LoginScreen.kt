package com.techun.dev.tuskillgt.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techun.dev.tuskillgt.R
import com.techun.dev.tuskillgt.ui.login.composables.TUSkillGTTextField
import org.koin.compose.viewmodel.koinViewModel

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginContent()
}

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel()
) {
//    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {


//            when (val state = uiState) {
//                is LoginUiState.Error -> TUSkillGTErrorScreen(message = state.message)
//                is LoginUiState.Idle -> {}
//                is LoginUiState.Loading -> TUSkillGTLoadingScreen()
//                is LoginUiState.Success -> {}
//            }
        }
    }
}

@Composable
fun LoginContent() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 44.dp),
            painter = painterResource(R.drawable.worldskills),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )

        TUSkillGTTextField(
            value = "",
            onValueChange = onNameChange,
            label = "Usuario",
            singleLine = true,
            shape = CircleShape,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
            )
        )
    }
}