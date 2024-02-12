package com.dmdbrands.balancehealth.ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmdbrands.balancehealth.R
import com.dmdbrands.balancehealth.model.LocalNavController
import com.dmdbrands.balancehealth.ui.shared.component.HelpPopUp
import com.dmdbrands.balancehealth.ui.shared.component.SharedViewModel
import com.dmdbrands.balancehealth.ui.theme.PrimaryColor
import com.dmdbrands.balancehealth.ui.theme.SurfaceColor

@Composable
fun TopBar() {
    val navController = LocalNavController.current
    val sharedviewmodel : SharedViewModel = hiltViewModel()
    HelpPopUp()
    Surface(
            modifier = Modifier.fillMaxWidth(),
            color = SurfaceColor
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(12.dp)
            ) {
                IconButton(onClick = { navController.popBackStack()} ) {
                    Icon(
                        painterResource(id = R.drawable.baseline_clear_24),
                        contentDescription = "",
                        tint = PrimaryColor,
                        modifier = Modifier.size(40.dp),

                    )
                }
                IconButton(onClick = { sharedviewmodel.openHelp() }) {
                    Icon(
                        painterResource(id = R.drawable.sharp_help_24),
                        contentDescription = "",
                        tint = PrimaryColor,
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