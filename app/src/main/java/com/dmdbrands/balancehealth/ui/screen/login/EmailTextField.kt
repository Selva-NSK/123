package com.dmdbrands.balancehealth.ui.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun EmailTextField(
    input :String,
    label : String,
    keyboardType: KeyboardType,
    onValueChange : (String) ->Unit,
) {
    Column {
        var isfocus = true
        val viewModel: LoginViewModel = hiltViewModel()
//        val email by viewModel.email.collectAsState()
        val isEmailEmpty by viewModel.isEmailEmpty.collectAsState()
        val isValidEmail by viewModel.isValidEmail.collectAsState()
        val isVisited by viewModel.isVisited.collectAsState()
        TextField(
            value = input,
            label = {
                Text(
                    text = label)
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged {
                    if (it.isFocused) {
                        viewModel.isVisited()
                        isfocus = true
                    } else if (!it.isFocused && isVisited) {
                        viewModel.checkEmail()
                    }

                }
        )
        if (isEmailEmpty) {
            Text(
                text = "Empty",
                color = Color.Red,
                fontSize = 12.sp
            )

        } else {
            if (!isValidEmail) {
                Text(
                    text = "Email id ",
                    color = Color.Red,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewTextField() {
    EmailTextField(input = "", label ="" , keyboardType = KeyboardType.Text, onValueChange ={} )
}