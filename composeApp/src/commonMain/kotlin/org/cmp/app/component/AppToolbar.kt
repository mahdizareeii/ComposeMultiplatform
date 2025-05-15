package org.cmp.app.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import org.cmp.appresources.Res
import org.cmp.appresources.ic_back_app_bar
import org.jetbrains.compose.resources.painterResource

@Composable
fun AppToolbar(
    title: String,
    onBackClick: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.onPrimary
            )
        },
        navigationIcon = {
            if (onBackClick != null) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_back_app_bar),
                        contentDescription = "Back",
                        tint = MaterialTheme.colors.onPrimary
                    )
                }
            }
        },
        actions = actions,
        contentColor = MaterialTheme.colors.primary
    )
}
