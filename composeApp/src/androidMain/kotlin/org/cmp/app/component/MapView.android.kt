package org.cmp.app.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.GoogleMap

@Composable
actual fun MapViewComponent(modifier: Modifier) {
    GoogleMap(modifier = modifier)
}