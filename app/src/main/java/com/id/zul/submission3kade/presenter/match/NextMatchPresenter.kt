package com.id.zul.submission3kade.presenter.match

import com.google.gson.Gson
import com.id.zul.submission3kade.api.Get
import com.id.zul.submission3kade.api.Request
import com.id.zul.submission3kade.coroutine.ProviderContext
import com.id.zul.submission3kade.model.match.Match
import com.id.zul.submission3kade.view.match.NextMatchView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NextMatchPresenter(
    private val view: NextMatchView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getNextMatch(query: String) {
        view.setLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.getRequestAsync(Get.getNextMatch(query)).await(),
                Match::class.java
            )
            view.setInItData(data.match)
            view.unSetLoading()
        }
    }

}