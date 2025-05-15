package org.cmp.app.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.cmp.app.getPlatform
import org.cmp.appresources.Res
import org.cmp.appresources.hi_platform
import org.cmp.appresources.listing
import org.cmp.appresources.map
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onShowMapClicked: () -> Unit,
    onShowListingClicked: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(Res.string.hi_platform, getPlatform().name))
        Spacer(Modifier.size(10.dp))
        Button(
            onClick = { onShowMapClicked.invoke() },
            content = { Text(stringResource(Res.string.map, getPlatform().name)) }
        )
        Spacer(Modifier.size(10.dp))
        Button(
            onClick = { onShowListingClicked.invoke() },
            content = { Text(stringResource(Res.string.listing, getPlatform().name)) }
        )
    }
}