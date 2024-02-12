package com.dmdbrands.balancehealth.ui.screen.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmdbrands.balancehealth.R
import com.dmdbrands.balancehealth.config.AppLang
import com.dmdbrands.balancehealth.ui.shared.component.HelpPopUp
import com.dmdbrands.balancehealth.ui.shared.component.SharedViewModel
import com.dmdbrands.balancehealth.ui.theme.SurfaceColor
import com.dmdbrands.balancehealth.ui.theme.PrimaryColor
import com.dmdbrands.balancehealth.ui.theme.BalanceHealthTheme
import com.dmdbrands.balancehealth.ui.theme.SubHeadingColor
import com.dmdbrands.balancehealth.ui.theme.SupportingTextColor

@Composable
fun LandingScreen()
{
    var sharedViewModel: SharedViewModel = hiltViewModel()
    val localUriHandler = LocalUriHandler.current

    Box(modifier = Modifier
        .fillMaxSize()
        .background(SurfaceColor)
    )
    {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            MiddleSection()
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 26.dp)
                .wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
            Image(
                painterResource(id = R.drawable.gg_logo),
                contentDescription = AppLang.Landing.Footer.gGLogoDescription,
                modifier = Modifier.height(62.dp),
                colorFilter = ColorFilter.tint(SupportingTextColor)
            )
            BottomTextComponent(
                text = AppLang.Landing.Footer.versionInfo,
                color = SubHeadingColor,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            )
            {
                BottomTextComponent(
                    text = AppLang.Landing.Footer.privacyPolicy,
                    color = PrimaryColor,
                    modifier = Modifier.clickable {localUriHandler.openUri(AppLang.URL.privacyURL)}
                )
                BottomTextComponent(
                    text = AppLang.Landing.Footer.divider,
                    color = SupportingTextColor,
                )
                BottomTextComponent(
                    text = AppLang.Landing.Footer.help,
                    color = PrimaryColor,
                    modifier = Modifier.clickable(onClick = {
                        sharedViewModel.openHelp()
                    } )
                )
                HelpPopUp()

            }
        }
    }
}



@Composable
fun ButtonComponent(modifier: Modifier=Modifier, text : String, color : Color, onClick : ()-> Unit) {
    Button(
        onClick = onClick,
        modifier.size(300.dp,55.dp),
        colors = ButtonDefaults.buttonColors(color)
    )
    {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 20.sp,
        )
    }

}



//@Preview(showSystemUi = true, showBackground = true)
@PreviewScreenSizes
@Composable
fun LandingScreenPreview() {
    BalanceHealthTheme {
    LandingScreen()

    }

}