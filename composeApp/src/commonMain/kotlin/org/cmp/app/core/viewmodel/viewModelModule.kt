package org.cmp.app.core.viewmodel

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        ProductViewModel(getProductUseCase = get())
    }
}