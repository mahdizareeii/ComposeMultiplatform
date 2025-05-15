package org.cmp.app.core.domain.usecase

import org.cmp.app.core.base.SafeResult
import org.cmp.app.core.domain.model.Product
import org.cmp.app.core.domain.repository.ProductsRepository

class GetProductUseCase(
    private val repository: ProductsRepository
) {
    suspend operator fun invoke(): SafeResult<List<Product>> {
        return repository.getProducts()
    }
}