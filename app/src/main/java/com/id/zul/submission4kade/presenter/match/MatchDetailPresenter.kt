package com.id.zul.submission4kade.presenter.match

import com.google.gson.Gson
import com.id.zul.submission4kade.api.Get
import com.id.zul.submission4kade.api.Request
import com.id.zul.submission4kade.coroutine.ProviderContext
import com.id.zul.submission4kade.model.match.Match
import com.id.zul.submission4kade.model.team.Team
import com.id.zul.submission4kade.view.match.MatchDetailView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MatchDetailPresenter(
    private val view: MatchDetailView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getMatchDetail(query: String) {
        view.setLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository.getRequestAsync(Get.getMatchDetail(query)).await(),
                Match::class.java
            )
            view.setInItDataMatch(data.match[0])
            view.unSetLoading()
        }
    }

    fun getTeamDetail(teamId: String, isHomeAWay: Boolean) {
        GlobalScope.launch(context.main) {
            view.setLoading()
            val dataTeams = gson.fromJson(
                apiRepository
                    .getRequestAsync(Get.getTeamDetail(teamId)).await(),
                Team::class.java
            )
            view.setInItDataTeam(dataTeams.teams[0], isHomeAWay)
            view.unSetLoading()
        }
    }

}