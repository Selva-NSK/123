package com.dmdbrands.balancehealth.ui.shared.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dmdbrands.balancehealth.model.LocalNavController
import com.dmdbrands.balancehealth.ui.theme.BalanceHealthTheme

@Composable
fun AppCompositionProvider(
    navController: NavHostController, content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalNavController provides navController) {
        content()
    }
}

@PreviewLightDark
@PreviewScreenSizes
@Composable
fun AppCompositionProviderPreview() {
    BalanceHealthTheme {
        AppCompositionProvider(navController = rememberNavController()){}
    }
}