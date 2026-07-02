package com.techun.dev.tuskillgt.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.techun.dev.tuskillgt.R
import com.techun.dev.tuskillgt.core.composables.TUSkillGTButton
import com.techun.dev.tuskillgt.core.composables.TUSkillGTText
import com.techun.dev.tuskillgt.ui.login.composables.TUSkillGTPasswordField
import com.techun.dev.tuskillgt.ui.login.composables.TUSkillGTTextField
import org.koin.compose.viewmodel.koinViewModel

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
        when (val state = uiState) {
            is LoginUiState.Success -> onLoginSuccess()
            is LoginUiState.Error -> snackbarHostState.showSnackbar(state.message)
            else -> Unit
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        LoginContent(
            modifier = Modifier.padding(paddingValues),
            uiState = uiState,
            user = user,
            onUserChange = { user = it },
            password = password,
            onPasswordChange = { password = it },
            onLoginClick = { viewModel.login(user, password) }
        )
    }
}

@Composable
fun LoginContent(
    uiState: LoginUiState,
    user: String,
    onUserChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
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

        TUSkillGTText(
            text = "Inicio de sesión",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        TUSkillGTText(
            text = "Ingresar para conocer SkillGT",
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(20.dp))

        TUSkillGTTextField(
            value = user,
            onValueChange = onUserChange,
            label = "Usuario",
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        TUSkillGTPasswordField(
            value = password,
            onValueChange = onPasswordChange,
            label = "Contraseña",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        TUSkillGTButton(
            onclick = onLoginClick,
            text = "Ingresar",
            shape = MaterialTheme.shapes.small,
            enabled = uiState !is LoginUiState.Loading
        )

        Spacer(modifier = Modifier.height(10.dp))

        TUSkillGTText(
            text = "Usuario: admin | Contraseña: 1234",
            color = Color.Gray
        )
    }
}