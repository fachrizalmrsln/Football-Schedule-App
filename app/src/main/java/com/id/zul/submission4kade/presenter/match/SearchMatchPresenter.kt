package com.id.zul.submission4kade.presenter.match

import com.google.gson.Gson
import com.id.zul.submission4kade.api.Get
import com.id.zul.submission4kade.api.Request
import com.id.zul.submission4kade.coroutine.ProviderContext
import com.id.zul.submission4kade.model.match.SearchMatch
import com.id.zul.submission4kade.view.match.SearchMatchView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchMatchPresenter(
    private val view: SearchMatchView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getNextMatch(query: String) {
        view.setLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.getRequestAsync(Get.getSearchMatch(query)).await(),
                SearchMatch::class.java
            )
            if (data.match.isNullOrEmpty()) {
                view.setNotFound()
                view.unSetLoading()
            } else {
                view.setInItData(data.match)
                view.unSetLoading()
            }
        }
    }

}