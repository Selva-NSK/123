package com.dmdbrands.balancehealth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.navigation.compose.rememberNavController
import com.dmdbrands.balancehealth.config.AppRoute
import com.dmdbrands.balancehealth.ui.shared.component.AppCompositionProvider
import com.dmdbrands.balancehealth.ui.theme.BalanceHealthTheme

@Composable
fun BalanceHealthApp() {
    val navController = rememberNavController()
    AppCompositionProvider(navController) {
        Scaffold {
            Surface(
                modifier = Modifier.fillMaxSize().padding(it),
                color = MaterialTheme.colorScheme.background
            ) {
                BalanceHealthNavGraph(navController = navController, AppRoute.LANDING)
            }
        }
    }
}

@PreviewLightDark
@PreviewScreenSizes
@Composable
fun BalanceHealthAppPreview() {
    BalanceHealthTheme {
        BalanceHealthApp()
    }
}