package org.cmp.app.core.domain

import org.cmp.app.core.domain.usecase.GetProductUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetProductUseCase(
            repository = get()
        )
    }
}