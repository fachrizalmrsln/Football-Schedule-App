package com.id.zul.submission5kade.api

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.URL

class Request {

    fun getRequestAsync(url: String): Deferred<String> = GlobalScope.async {
        URL(url).readText()
    }

}