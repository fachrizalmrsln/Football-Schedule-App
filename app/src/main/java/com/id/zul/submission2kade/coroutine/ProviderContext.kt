package com.id.zul.submission2kade.coroutine

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class ProviderContext {
    open val main: CoroutineContext by lazy {
        Dispatchers.Main
    }
}

