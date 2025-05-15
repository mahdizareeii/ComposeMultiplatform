package org.cmp.app.core.data.network

import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun networkEngineModule(): Module = module {
    single { Darwin.create() }
}