package com.dmdbrands.balancehealth.ui.screen.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmdbrands.balancehealth.ui.shared.component.SharedViewModel
import com.dmdbrands.balancehealth.ui.theme.DisabledColor
import com.dmdbrands.balancehealth.ui.theme.PrimaryColor
import com.dmdbrands.balancehealth.ui.theme.SurfaceColor

@Composable
fun ForgotPassword() {
    val viewModel : LoginViewModel = hiltViewModel()
    val emailState by viewModel.emailState.collectAsState()
    val sharedViewModel : SharedViewModel = hiltViewModel()
    val ishelpVisible by sharedViewModel.isHelpVisible.collectAsState()
    Box(
            modifier = Modifier
                .fillMaxSize()
                .background(SurfaceColor),
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
                Column (
                    modifier= Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp, bottom = 30.dp)
                        .padding(start = 24.dp, end = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                        CustomText(text = "Forgot Your Password?")
                        CustomText(text = "Enter your email for a link to reset password")
                    Spacer(modifier = Modifier.height(20.dp))
                    EmailTextField(viewModel = viewModel)
                    Button(
                        onClick = { Log.i("Selva","${emailState.email}") },
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        enabled = emailState.isButtonEnabled,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryColor,
                            contentColor = Color.White,
                            disabledContentColor = Color.White,
                            disabledContainerColor = DisabledColor
                        )
                    ) {
                        Text(
                            text = "RESET PASSWORD",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp)

                    }
                }
            }
        }
    }
@Composable
fun CustomText(text : String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCardFPwd() {
    ForgotPassword()
}