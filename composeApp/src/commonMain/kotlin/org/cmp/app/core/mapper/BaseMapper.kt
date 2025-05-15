package org.cmp.app.core.mapper

interface BaseMapper<in From, out To> {
    abstract fun map(from: From): To
}