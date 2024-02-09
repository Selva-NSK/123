package com.dmdbrands.balancehealth.ui.screen.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmdbrands.balancehealth.config.AppRoute
import com.dmdbrands.balancehealth.model.LocalNavController
import com.dmdbrands.balancehealth.ui.theme.DisabledComponentColor
import com.dmdbrands.balancehealth.ui.theme.ActiveComponentColor
import com.dmdbrands.balancehealth.ui.theme.SetupBackgroundColor


@Composable
fun LoginScreen() {
    val viewModel: LoginViewModel = hiltViewModel()
    val email by viewModel.email.collectAsState()
    val pwd by viewModel.password.collectAsState()
    val dummy by viewModel.dummy.collectAsState()
    val buttonState by viewModel.buttonState.collectAsState()
    val focus = LocalFocusManager.current
    val navController = LocalNavController.current
    val view = LocalView.current
    Box(
            modifier = Modifier
                .imePadding()
                .background(SetupBackgroundColor)
                .fillMaxSize()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) { focus.clearFocus() }
                ) {
                    TopBar()
                    ElevatedCard(
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier
                            .padding(20.dp)
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 30.dp, bottom = 30.dp)
                                .padding(start = 24.dp, end = 24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(30.dp)
                        ) {
                            Text(
                                text = "Welcome back!",
                                style = MaterialTheme.typography.labelLarge,
                                fontSize = 20.sp
                            )
                            EmailTextField(viewModel)
                            PasswordTextField(viewModel)
                            Button(
                                onClick = {
                                    focus.clearFocus()
                                    viewModel.checkcred(email,pwd)
                                          },
                                enabled = buttonState,
                                modifier = Modifier
                                    .height(45.dp)
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = ActiveComponentColor,
                                    disabledContainerColor = DisabledComponentColor,
                                    contentColor = Color.White,
                                    disabledContentColor = Color.White
                                )
                            ) {
                                Text(text = "LOGIN")
                            }
                            if(dummy)
                                navController.popBackStack()
                            TextButton(
                                onClick = { navController.navigate(AppRoute.FORGOTPWD) },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transpa  n                                                                                                                                                                             rent,
                                    contentColor = ActiveComponentColor
                                )
                            )
                            {
                                Text(
                                    text = "FORGOT YOUR PASSWORD?",
                                    style = MaterialTheme.typography.bodyLarge
                                )
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