package com.techun.dev.tuskillgt.ui.login.composables

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.techun.dev.tuskillgt.core.composables.TUSkillGTText

@Composable
fun TUSkillGTPasswordField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    shape: Shape = MaterialTheme.shapes.medium,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = modifier,
        shape = shape,
        label = { TUSkillGTText(text = label) },
        value = value,
        onValueChange = onValueChange,
        colors = colors,
        singleLine = true,
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
//            val icon = if (passwordVisible) Icons.Filled.VisibilityOff else Icons.Default.Visibility
            val icon = if (passwordVisible) Icons.Filled.Info else Icons.Filled.Home
            val description = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = icon, contentDescription = description)
            }
        }
    )
}