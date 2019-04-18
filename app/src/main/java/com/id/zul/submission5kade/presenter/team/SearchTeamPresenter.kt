package com.id.zul.submission5kade.presenter.team

import android.util.Log
import com.google.gson.Gson
import com.id.zul.submission5kade.api.Get
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.coroutine.ProviderContext
import com.id.zul.submission5kade.model.team.SearchTeam
import com.id.zul.submission5kade.view.team.SearchTeamView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SearchTeamPresenter(
    private val view: SearchTeamView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getSearchedTeam(query: String) {
        view.setLoading()
        Log.d("SearchTeamPresenter", query)
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.getRequestAsync(Get.getSearchTeam(query)).await(),
                SearchTeam::class.java
            )
            Log.d("SearchTeamPresenter", data.toString())
            if (data.teams.isNullOrEmpty()) {
                view.setNotFound()
                view.unSetLoading()
            } else {
                view.setInItData(data.teams)
                view.unSetLoading()
            }
        }
    }

}