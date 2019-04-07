package com.id.zul.submission2kade.presenter.match

import com.google.gson.Gson
import com.id.zul.submission2kade.api.Get
import com.id.zul.submission2kade.api.Request
import com.id.zul.submission2kade.coroutine.ProviderContext
import com.id.zul.submission2kade.model.match.Previous
import com.id.zul.submission2kade.view.match.PreviousMatchView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PreviousMatchPresenter(
    private val view: PreviousMatchView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getPreviousMatch(query: String) {
        view.setLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.getRequestAsync(Get.getPreviousMatch(query)).await(),
                Previous::class.java
            )
            view.setInItData(data.previous)
            view.unSetLoading()
        }
    }

}