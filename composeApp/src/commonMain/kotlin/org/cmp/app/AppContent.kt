package org.cmp.app

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.cmp.app.component.AppToolbar
import org.cmp.app.screen.home.HomeScreen
import org.cmp.app.screen.map.MapScreen
import org.cmp.app.screen.product.ProductScreen
import org.cmp.appresources.Res
import org.cmp.appresources.app_name
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AppContent() {
    var currentScreen by remember { mutableStateOf<Screens>(Screens.Home) }

    MaterialTheme {
        Scaffold(
            topBar = {
                AppToolbar(
                    title = stringResource(Res.string.app_name),
                    onBackClick = {
                        currentScreen = Screens.Home
                    }
                )
            },
            content = { paddingValues ->
                when (currentScreen) {
                    Screens.Home -> HomeScreen(
                        onShowMapClicked = { currentScreen = Screens.Map },
                        onShowListingClicked = { currentScreen = Screens.Listing }
                    )

                    Screens.Listing -> ProductScreen()
                    Screens.Map -> MapScreen()
                }
            }
        )
    }
}


sealed class Screens {
    data object Home : Screens()
    data object Map : Screens()
    data object Listing : Screens()
}