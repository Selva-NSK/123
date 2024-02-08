package com.dmdbrands.balancehealth

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dmdbrands.balancehealth.config.AppRoute
import com.dmdbrands.balancehealth.ui.screen.landing.LandingScreen
import com.dmdbrands.balancehealth.ui.screen.login.ForgotPassword
import com.dmdbrands.balancehealth.ui.screen.login.LoginScreen
import com.dmdbrands.balancehealth.ui.theme.BalanceHealthTheme

@Composable
fun BalanceHealthNavGraph(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination ){
        composable(AppRoute.LANDING){ LandingScreen() }
        composable(AppRoute.LOGIN){ LoginScreen() }
        composable(AppRoute.FORGOTPWD){ ForgotPassword() }
    }
}

@PreviewLightDark
@PreviewScreenSizes
@Composable
fun BalanceHealthNavGraphPreview() {
    BalanceHealthTheme {
        BalanceHealthNavGraph(rememberNavController(), AppRoute.LANDING)
    }
}