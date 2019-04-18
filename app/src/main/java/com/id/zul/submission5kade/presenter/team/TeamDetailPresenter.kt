package com.id.zul.submission5kade.presenter.team

import com.google.gson.Gson
import com.id.zul.submission5kade.api.Get
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.coroutine.ProviderContext
import com.id.zul.submission5kade.model.team.Team
import com.id.zul.submission5kade.view.team.TeamDetailView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TeamDetailPresenter(
    private val view: TeamDetailView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getTeamDetail(teamId: String) {
        GlobalScope.launch(context.main) {
            view.setLoading()
            val dataTeams = gson.fromJson(
                apiRepository
                    .getRequestAsync(Get.getTeamDetail(teamId)).await(),
                Team::class.java
            )
            view.setInItData(dataTeams.teams[0])
            view.unSetLoading()
        }
    }
}