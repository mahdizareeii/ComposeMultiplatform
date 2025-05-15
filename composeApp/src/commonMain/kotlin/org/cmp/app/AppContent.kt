package org.cmp.app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.cmp.app.screens.ProductScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun AppContent() {
    MaterialTheme {
        //MapViewComponent()
        ProductScreen()
    }
}