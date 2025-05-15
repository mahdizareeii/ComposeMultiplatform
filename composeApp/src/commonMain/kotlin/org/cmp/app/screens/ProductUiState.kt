package org.cmp.app.screens

import org.cmp.app.core.domain.model.Product

data class ProductUiState(
    val products: List<Product> = listOf()
)
