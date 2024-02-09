package com.dmdbrands.balancehealth.ui.screen.login

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmdbrands.balancehealth.ui.theme.SupportingTextColor

@Composable
fun PasswordTextField(viewModel : LoginViewModel) {

    val password by viewModel.password.collectAsState()
    val isPasswordVisted by viewModel.isPasswordVisited.collectAsState()
    val isPasswordEmpty by viewModel.isPasswordEmpty.collectAsState()
    var passvisibility = rememberSaveable{ mutableStateOf(false) }
    val icon = if(passvisibility.value) Icons.Filled.Visibility else { Icons.Filled.VisibilityOff }
    TextField(
        singleLine = true,
        modifier = Modifier
            .onFocusChanged {
                if (it.isFocused) {
                    viewModel.isPasswordVisited()
                } else if (!it.isFocused && isPasswordVisted) {
                    viewModel.checkPassword()
                }

            }
            .fillMaxWidth()
            .padding(0.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            errorTextColor = Color.Red,
            focusedLabelColor = SupportingTextColor,
            unfocusedLabelColor = SupportingTextColor
        ),
        supportingText = {
            if (isPasswordEmpty) {
                Text(
                    text = "Field Shouldn't be empty*",
                    color = Color.Red,
                )

            }
        },
        value = password,
        onValueChange = { newValue ->
            viewModel.setPassword(newValue)
        },
        label = {
            Text(
                text = "PASSWORD",
            )
        },
        trailingIcon = {
            IconButton(onClick = { passvisibility.value = !passvisibility.value}){
                Icon(imageVector = icon,contentDescription = null)
            }
        },
        visualTransformation = if(passvisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

    )


}