package com.techun.dev.tuskillgt.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.techun.dev.tuskillgt.R
import com.techun.dev.tuskillgt.core.composables.TUSkillGTText
import com.techun.dev.tuskillgt.ui.login.composables.TUSkillGTPasswordField
import com.techun.dev.tuskillgt.ui.login.composables.TUSkillGTTextField
import org.koin.compose.viewmodel.koinViewModel

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginContent()
}

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    onLoginSuccess: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    var user by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState) {
        if (uiState is LoginUiState.Success) {
            onLoginSuccess()
        }
        if (uiState is LoginUiState.Error) {
            snackbarHostState.showSnackbar((uiState as LoginUiState.Error).message)
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
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
    var user by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
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
            value = user,
            onValueChange = { user = it },
            label = "Usuario",
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        TUSkillGTPasswordField(
            value = password,
            onValueChange = { password = it },
            label = "Contraseña",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

//        Button(
//            onClick = { onLoginClick(user, password) },
//            enabled = uiState !is LoginUiState.Loading,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(48.dp)
//        ) {
//            if (uiState is LoginUiState.Loading) {
//                CircularProgressIndicator(
//                    modifier = Modifier.size(20.dp),
//                    strokeWidth = 2.dp,
//                    color = MaterialTheme.colorScheme.onPrimary
//                )
//            } else {
//                TUSkillGTText("Ingresar")
//            }
//        }
    }
}