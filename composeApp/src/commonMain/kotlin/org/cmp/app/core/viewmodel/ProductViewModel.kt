package org.cmp.app.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.cmp.app.core.base.BaseUiState
import org.cmp.app.core.base.SafeResult
import org.cmp.app.core.domain.usecase.GetProductUseCase
import org.cmp.app.screen.product.ProductUiState

class ProductViewModel(
    private val getProductUseCase: GetProductUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<BaseUiState<ProductUiState>>(
        BaseUiState.InitialUiState
    )

    val uiState = _uiState.asStateFlow()

    private var productUiState = ProductUiState()
        private set(value) {
            field = value
            _uiState.update { BaseUiState.SuccessUiState(value) }
        }

    fun getProducts() {
        viewModelScope.launch {
            _uiState.update { BaseUiState.LoadingUiState() }
            when (val result = getProductUseCase.invoke()) {
                is SafeResult.Success -> {
                    productUiState = productUiState.copy(products = result.data)
                }

                is SafeResult.Error -> _uiState.update { BaseUiState.ErrorUiState(result.error) }
            }
        }
    }

}