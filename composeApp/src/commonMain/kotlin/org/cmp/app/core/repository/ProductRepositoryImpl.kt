package org.cmp.app.core.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.cmp.app.core.base.SafeResult
import org.cmp.app.core.base.safeResult
import org.cmp.app.core.data.network.api.ProductApi
import org.cmp.app.core.data.network.model.ProductDto
import org.cmp.app.core.domain.model.Product
import org.cmp.app.core.domain.repository.ProductsRepository
import org.cmp.app.core.mapper.BaseMapper

class ProductRepositoryImpl(
    private val api: ProductApi,
    private val mapper: BaseMapper<ProductDto, Product>
) : ProductsRepository {
    override suspend fun getProducts(): SafeResult<List<Product>> {
        return withContext(Dispatchers.Default) {
            when (val result = api.getProducts().safeResult()) {
                is SafeResult.Success -> SafeResult.Success(result.data.map { mapper.map(it) })
                is SafeResult.Error -> result
            }
        }
    }
}