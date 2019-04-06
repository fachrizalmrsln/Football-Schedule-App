package com.id.zul.submission2kade.api

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.URL

class Request {

    fun getRequest(url: String): Deferred<String> = GlobalScope.async {
        URL(url).readText()
    }

}