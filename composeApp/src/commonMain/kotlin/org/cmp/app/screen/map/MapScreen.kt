package org.cmp.app.screen.map

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.cmp.app.component.MapViewComponent

@Composable
fun MapScreen(modifier: Modifier = Modifier) {
    MapViewComponent(modifier = modifier.fillMaxSize())
}