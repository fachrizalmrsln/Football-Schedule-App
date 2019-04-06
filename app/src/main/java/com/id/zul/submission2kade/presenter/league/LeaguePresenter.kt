package com.id.zul.submission2kade.presenter.league

import com.google.gson.Gson
import com.id.zul.submission2kade.api.Get
import com.id.zul.submission2kade.api.Request
import com.id.zul.submission2kade.coroutine.CoroutinesContext
import com.id.zul.submission2kade.model.league.League
import com.id.zul.submission2kade.view.league.LeagueView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LeaguePresenter(
    private val view: LeagueView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: CoroutinesContext = CoroutinesContext()
) {

    fun getLeagueList(query: String) {
        view.setLoading()

        GlobalScope.launch(context.main) {
            val dataLeague = gson.fromJson(
                apiRepository
                    .getRequest(Get.getDetailInLeague(query)),
                League::class.java
            )
            view.setInItData(dataLeague.league)
            view.unSetLoading()
        }
    }

}