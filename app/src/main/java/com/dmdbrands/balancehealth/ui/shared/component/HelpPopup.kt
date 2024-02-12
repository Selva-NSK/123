package com.dmdbrands.balancehealth.ui.shared.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmdbrands.balancehealth.R
import com.dmdbrands.balancehealth.config.AppLang
import com.dmdbrands.balancehealth.ui.theme.BalanceHealthTheme
import com.dmdbrands.balancehealth.ui.theme.PrimaryColor


@Composable
fun HelpPopUp() {
    val viewModel: SharedViewModel = hiltViewModel()
    val isHelpVisible by viewModel.isHelpVisible.collectAsState()
    if(isHelpVisible)
    Dialog(
        onDismissRequest = { viewModel.closeHelp()},
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 25.dp, start = 10.dp),
                horizontalArrangement = Arrangement.Start,

                ) {
                IconButton(
                    onClick = { viewModel.closeHelp() },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = PrimaryColor
                    ),

                    ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = AppLang.HelpPopUp.closeIconDescription,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(top = 0.dp, bottom = 10.dp, start = 20.dp, end = 20.dp)
                    .wrapContentSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(id = R.drawable.gg_stamp),
                    contentDescription = AppLang.HelpPopUp.gGStampDescription,
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = AppLang.HelpPopUp.heading,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center



                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = AppLang.HelpPopUp.subHeading,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(20.dp))
                ContactInfo(Icons.Outlined.Phone, text = AppLang.HelpPopUp.phoneContact) {

                }
                Spacer(modifier = Modifier.height(1.dp))
                ContactInfo(
                    imageVector = Icons.Outlined.Mail,
                    text = AppLang.HelpPopUp.emailContact
                ) {

                }
                Spacer(modifier = Modifier.height(18.dp))
            }

        }
    }
}

@Composable
fun ContactInfo(imageVector: ImageVector,text : String,onClick : () -> Unit) {
   TextButton(onClick = onClick) {
       Icon(
           imageVector = imageVector,
           contentDescription = AppLang.HelpPopUp.contactDescription,
           tint = PrimaryColor,
           modifier = Modifier.size(ButtonDefaults.IconSize))
       Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
       Text(
           text = text,
           modifier = Modifier
               .padding(top = 1.dp)
               .clickable(onClick = onClick),
           color = PrimaryColor,

           style = MaterialTheme.typography.labelLarge,
       )
   }


   }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AlertPreviw() {
    BalanceHealthTheme {
    HelpPopUp( )

    }
}
