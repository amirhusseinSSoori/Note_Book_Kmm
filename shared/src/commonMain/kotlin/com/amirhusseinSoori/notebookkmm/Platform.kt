package com.amirhusseinSoori.notebookkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform