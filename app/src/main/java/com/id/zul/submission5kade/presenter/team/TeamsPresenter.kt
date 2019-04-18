package com.id.zul.submission5kade.presenter.team

import com.google.gson.Gson
import com.id.zul.submission5kade.api.Get
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.coroutine.ProviderContext
import com.id.zul.submission5kade.model.team.Team
import com.id.zul.submission5kade.view.team.TeamsView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamsPresenter(
    private val view: TeamsView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getLeagueList(query: String) {
        view.setLoadingTeam()

        GlobalScope.launch(context.main) {
            val dataLeague = gson.fromJson(
                apiRepository
                    .getRequestAsync(Get.getTeams(query)).await(),
                Team::class.java
            )
            view.setInItData(dataLeague.teams)
            view.unSetLoadingTeam()
        }
    }

}