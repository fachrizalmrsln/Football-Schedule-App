package com.id.zul.submission3kade.coroutine

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class ProviderContext {
    open val main: CoroutineContext by lazy {
        Dispatchers.Main
    }
}

