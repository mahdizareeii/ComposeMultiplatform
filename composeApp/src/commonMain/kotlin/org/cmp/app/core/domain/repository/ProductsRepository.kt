package org.cmp.app.core.domain.repository

import org.cmp.app.core.base.SafeResult
import org.cmp.app.core.domain.model.Product

interface ProductsRepository {
    suspend fun getProducts(): SafeResult<List<Product>>
}