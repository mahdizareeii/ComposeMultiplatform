package org.cmp.app.screen.product

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.cmp.app.component.ProductSkeletonView
import org.cmp.app.component.ProductView
import org.cmp.app.component.TryAgainView
import org.cmp.app.core.base.BaseUiState
import org.cmp.app.core.viewmodel.ProductViewModel
import org.cmp.appresources.Res
import org.cmp.appresources.internet_connection_error
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProductScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel = koinViewModel()
) {
    var productUiState by remember { mutableStateOf(ProductUiState()) }
    val uiState by viewModel.uiState.collectAsState()
    when (val state = uiState) {
        is BaseUiState.InitialUiState -> viewModel.getProducts()
        is BaseUiState.EmptyUiState -> {}
        is BaseUiState.ErrorUiState -> {}
        is BaseUiState.LoadingUiState -> {}
        is BaseUiState.SuccessUiState -> {
            productUiState = state.state
        }
    }

    if (uiState is BaseUiState.ErrorUiState) {
        TryAgainView(
            message = stringResource(Res.string.internet_connection_error),
            onRetry = { viewModel.getProducts() }
        )
    }

    if (uiState is BaseUiState.LoadingUiState) {
        ProductSkeletonView()
    }

    LazyColumn(modifier) {
        items(items = productUiState.products) {
            Spacer(Modifier.size(2.5.dp))
            ProductView(it)
            Spacer(Modifier.size(2.5.dp))
        }
    }
}