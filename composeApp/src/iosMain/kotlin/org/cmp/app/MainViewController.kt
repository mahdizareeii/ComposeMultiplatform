package org.cmp.app

import androidx.compose.ui.window.ComposeUIViewController
import org.koin.dsl.KoinAppDeclaration

fun MainViewController(koinAppDeclaration: KoinAppDeclaration) = ComposeUIViewController {
    App(koinAppDeclaration)
}