package com.dmdbrands.balancehealth.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmdbrands.balancehealth.config.AppRoute
import com.dmdbrands.balancehealth.model.LocalNavController
import com.dmdbrands.balancehealth.ui.theme.DisabledComponentColor
import com.dmdbrands.balancehealth.ui.theme.ActiveComponentColor
import com.dmdbrands.balancehealth.ui.theme.SetupBackgroundColor
import com.dmdbrands.balancehealth.ui.theme.SupportingTextColor


@Composable
fun LoginScreen() {
    val navController = LocalNavController.current
        Box(
            modifier = Modifier
                .background(SetupBackgroundColor)
                .fillMaxSize(),
        ) {
            TopBar()
            val viewModel: LoginViewModel = hiltViewModel()
            val password by viewModel.password.collectAsState()
            val email by viewModel.email.collectAsState()
            val isValidEmail by viewModel.isEmailEmpty.collectAsState()
            val emailfield = remember { (mutableStateOf(false)) }
            var isHelpVisible = rememberSaveable {
                mutableStateOf(false)
            }
//            val counter by viewModel.counter.collectAsState()
            val isVisited by viewModel.isVisited.collectAsState()
            var buttonstate:Boolean=false
            ElevatedCard(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .align(Alignment.Center),
                shape = RoundedCornerShape(25.dp)
            ) {
                Column (
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, bottom = 30.dp)
                        .padding(start = 24.dp, end = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ){
                    Text(
                        text = "Welcome back!",
                        style = MaterialTheme.typography.labelLarge,
                        fontSize = 20.sp
                    )
                        EmailTextField(
                            input = email,
                            label = "EMAIL",
                            keyboardType = KeyboardType.Email
                        ) { newvalue ->
                            viewModel.setEmail(newvalue)
                        }

                    var passvisibility = rememberSaveable{
                        mutableStateOf(false)
                    }
                    val icon = if(passvisibility.value) Icons.Filled.Visibility else {
                        Icons.Filled.VisibilityOff
                    }
                    TextField(
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            errorTextColor = Color.Red,
                            focusedLabelColor = SupportingTextColor,
                            unfocusedLabelColor = SupportingTextColor),
                        value = password,
                        onValueChange = {
                            viewModel.setPassword(it)
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
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )
                    Button(
                        onClick = { /*TODO*/ },
                        enabled = buttonstate,
                        modifier = Modifier
                            .height(45.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = ActiveComponentColor,
                            disabledContainerColor = DisabledComponentColor,
                            contentColor = Color.White,
                            disabledContentColor = Color.White
                        )) {
                        Text(text = "LOGIN")
                    }
                    TextButton(
                        onClick = { navController.navigate(AppRoute.FORGOTPWD) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = ActiveComponentColor))
                    {
                        Text(
                            text = "FORGOT YOUR PASSWORD?",
                            style= MaterialTheme.typography.bodyLarge)
                    }

                }
            }

        }
    }

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreenPreview() {
        LoginScreen()
}