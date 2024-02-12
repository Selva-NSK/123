package com.dmdbrands.balancehealth.ui.screen.login

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
import com.dmdbrands.balancehealth.ui.theme.BalanceHealthTheme

@Composable
fun EmailTextField( viewModel: LoginViewModel) {
    val emailState by viewModel.emailState.collectAsState()
    Column {
        TextField(
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()

                .onFocusChanged {
                    if (it.isFocused) {
                        viewModel.isEmailVisited()
                    } else if (!it.isFocused && emailState.isEmailVisited) {
                        viewModel.checkEmail()
                    }

                },
            value = emailState.email,
            onValueChange = {
                    newvalue ->
                viewModel.setEmail(newvalue) },
            label = {
                Text(
                    text = "EMAIL")
            },
            supportingText = {
                when(emailState.emailErrorCode) {
                    (1) -> Text(
                        text = "Field Shouldn't be empty*",
                        color = Color.Red,
                    )
                    (2) -> Text(
                            text = "Invalid Email",
                            color = Color.Red,
                        )
                    }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Done),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            )
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTextField() {
    BalanceHealthTheme {
    EmailTextField( hiltViewModel())
    }
}