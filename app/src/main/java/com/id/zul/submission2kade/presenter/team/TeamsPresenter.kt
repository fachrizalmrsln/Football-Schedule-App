package com.id.zul.submission2kade.presenter.team

import com.google.gson.Gson
import com.id.zul.submission2kade.api.Get
import com.id.zul.submission2kade.api.Request
import com.id.zul.submission2kade.coroutine.ProviderContext
import com.id.zul.submission2kade.model.team.Team
import com.id.zul.submission2kade.view.team.TeamsView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamsPresenter(
    private val view: TeamsView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getLeagueList(query: String) {
        view.setLoading()

        GlobalScope.launch(context.main) {
            val dataLeague = gson.fromJson(
                apiRepository
                    .getRequest(Get.getTeams(query)).await(),
                Team::class.java
            )
            view.setInItData(dataLeague.teams)
            view.unSetLoading()
        }
    }

}