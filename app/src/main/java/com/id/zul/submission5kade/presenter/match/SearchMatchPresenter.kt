package com.id.zul.submission5kade.presenter.match

import com.google.gson.Gson
import com.id.zul.submission5kade.api.Get
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.coroutine.ProviderContext
import com.id.zul.submission5kade.model.match.SearchMatch
import com.id.zul.submission5kade.view.match.SearchMatchView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchMatchPresenter(
    private val view: SearchMatchView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getSearchedMatch(query: String) {
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