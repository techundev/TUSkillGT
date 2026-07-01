package com.techun.dev.tuskillgt.ui.login.composables

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.techun.dev.tuskillgt.core.composables.TUSkillGTText

@Composable
fun TUSkillGTTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "",
    shape: Shape = MaterialTheme.shapes.medium,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    singleLine: Boolean = false,
) {
    OutlinedTextField(
        modifier = modifier,
        shape = shape,
        label = {
            TUSkillGTText(
                text = label,
            )
        },
        value = value,
        onValueChange = { onValueChange(it) },
        colors = colors,
        singleLine = singleLine
    )
}