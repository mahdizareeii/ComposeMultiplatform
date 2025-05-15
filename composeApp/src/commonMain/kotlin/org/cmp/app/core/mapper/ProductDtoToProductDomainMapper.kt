package org.cmp.app.core.mapper

import org.cmp.app.core.data.network.model.ProductDto
import org.cmp.app.core.domain.model.Product

class ProductDtoToProductDomainMapper : BaseMapper<ProductDto, Product> {
    override fun map(from: ProductDto): Product {
        return Product(
            creditLine = from.creditLine ?: "",
            department = from.department ?: "",
            description = from.medium ?: "",
            image = from.primaryImageSmall ?: "",
            title = from.title ?: ""
        )
    }
}