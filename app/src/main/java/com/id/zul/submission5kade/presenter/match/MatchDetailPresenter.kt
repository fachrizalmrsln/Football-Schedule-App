package com.id.zul.submission5kade.presenter.match

import com.google.gson.Gson
import com.id.zul.submission5kade.api.Get
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.coroutine.ProviderContext
import com.id.zul.submission5kade.model.match.Match
import com.id.zul.submission5kade.model.team.Team
import com.id.zul.submission5kade.view.match.MatchDetailView
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