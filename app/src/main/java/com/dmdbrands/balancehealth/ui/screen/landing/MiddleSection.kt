package com.dmdbrands.balancehealth.ui.screen.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dmdbrands.balancehealth.R
import com.dmdbrands.balancehealth.config.AppLang
import com.dmdbrands.balancehealth.config.AppRoute
import com.dmdbrands.balancehealth.model.LocalNavController
import com.dmdbrands.balancehealth.ui.theme.PrimaryColor
import com.dmdbrands.balancehealth.ui.theme.SupportingTextColor

@Composable
fun MiddleSection() {
    val navController= LocalNavController.current
    Image(
        painterResource(id  = R.drawable.applogo),
        contentDescription = AppLang.Landing.balanceIconDescription,
        modifier = Modifier.width(310.dp),
        colorFilter = ColorFilter.tint(SupportingTextColor)
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = AppLang.Landing.companyName,
        style = MaterialTheme.typography.bodyLarge,
        color = SupportingTextColor
    )
    Spacer(modifier = Modifier.height(50.dp))
    ButtonComponent(text = AppLang.Landing.loginButton, color = PrimaryColor ) {
        navController.navigate(AppRoute.LOGIN)
    }
    Spacer(modifier = Modifier.height(16.dp))
    ButtonComponent(text = AppLang.Landing.signupButton, color = SupportingTextColor) {
        { }
    }
    Spacer(modifier = Modifier.height(110.dp))
}

@Composable
fun BottomTextComponent(text: String, color: Color, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = color,
        style = MaterialTheme.typography.bodySmall,
        modifier=modifier
    )
}