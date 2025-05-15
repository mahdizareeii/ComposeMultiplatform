package org.cmp.app.core.repository

import org.cmp.app.core.domain.repository.ProductsRepository
import org.cmp.app.core.mapper.ProductDtoToProductDomainMapper
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        ProductRepositoryImpl(
            api = get(),
            mapper = ProductDtoToProductDomainMapper()
        )
    } bind ProductsRepository::class
}