package com.dmdbrands.balancehealth.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dmdbrands.balancehealth.config.AppLang
import com.dmdbrands.balancehealth.ui.theme.ActiveComponentColor
import com.dmdbrands.balancehealth.ui.theme.SetupBackgroundColor

@Composable
fun TopBar() {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = SetupBackgroundColor
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(12.dp)
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "",
                        tint = ActiveComponentColor,
                        modifier = Modifier.size(40.dp))
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Outlined.Circle,
                        contentDescription = "AppLang.SignUp.helpIconContentDescription",
                        tint = SetupBackgroundColor,
                        modifier = Modifier
                            .size(30.dp)
                            .background(color = SetupBackgroundColor, shape = CircleShape)
                            .border(width = 2.dp, color = ActiveComponentColor, shape = CircleShape)
                    )
                    Icon(
                        imageVector = Icons.Outlined.QuestionMark,
                        contentDescription = AppLang.HelpPopUp.contactDescription,
                        tint = ActiveComponentColor,
                        modifier = Modifier.size(15.dp)
                    )
                }
            }
        }
    }

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun PreviewTopBar() {
    TopBar()
}