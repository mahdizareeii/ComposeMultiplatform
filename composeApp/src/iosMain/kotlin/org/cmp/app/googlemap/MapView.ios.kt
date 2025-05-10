package org.cmp.app.googlemap

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.UIKitView
import cocoapods.GoogleMaps.GMSMapView
import kotlinx.cinterop.ExperimentalForeignApi

//Call the GMSServices.provideAPIKey("YOUR_API_KEY") in your AppDelegate of ios app base on the documentation
@OptIn(ExperimentalForeignApi::class)
@Composable
actual fun MapViewComponent() {
    UIKitView(
        factory = {
            GMSMapView()
        },
        update = {

        }
    )
}