package org.cmp.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform