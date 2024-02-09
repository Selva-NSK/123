package com.dmdbrands.balancehealth.ui.screen.login

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun EmailTextField( viewModel: LoginViewModel) {
    Column {
        val email by viewModel.email.collectAsState()
        val isEmailEmpty by viewModel.isEmailEmpty.collectAsState()
        val isValidEmail by viewModel.isValidEmail.collectAsState()
        val isEmailVisited by viewModel.isEmailVisited.collectAsState()
        TextField(
            value = email,
            label = {
                Text(
                    text = "EMAIL")
            },
            supportingText = {
                if (isEmailEmpty) {
                    Text(
                        text = "Field Shouldn't be empty*",
                        color = Color.Red,
                    )

                } else {
                    if (!isValidEmail) {
                        Text(
                            text = "Invalid Email",
                            color = Color.Red,
                        )
                    }
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Done),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            onValueChange = {
                newvalue ->
                viewModel.setEmail(newvalue) },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    if (it.isFocused) {
                        viewModel.isEmailVisited()
                    } else if (!it.isFocused && isEmailVisited) {
                        viewModel.checkEmail()
                    }

                },
        )
    }
}

@Preview
@Composable
fun PreviewTextField() {
    EmailTextField( hiltViewModel())
}