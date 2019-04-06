package com.id.zul.submission2kade.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class Request {

    suspend fun getRequest(url: String): String =
        withContext(Dispatchers.Default) {
            URL(url).readText()
        }

}