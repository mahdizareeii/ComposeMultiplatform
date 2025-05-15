package org.cmp.app.di

import org.cmp.app.core.data.local.localModule
import org.cmp.app.core.data.network.networkEngineModule
import org.cmp.app.core.data.network.networkModule
import org.cmp.app.core.domain.domainModule
import org.cmp.app.core.repository.repositoryModule
import org.cmp.app.core.viewmodel.viewModelModule

fun getAllKoinModules() = listOf(
    repositoryModule,
    domainModule,
    networkModule,
    localModule,
    viewModelModule,
    networkEngineModule()
)