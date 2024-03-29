package com.id.zul.submission5kade.presenter.league

import com.google.gson.Gson
import com.id.zul.submission5kade.api.Get
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.coroutine.ProviderContext
import com.id.zul.submission5kade.model.league.League
import com.id.zul.submission5kade.view.league.LeagueView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LeaguePresenter(
    private val view: LeagueView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getDetailLeague(query: String) {
        view.setLoading()
        GlobalScope.launch(context.main) {
            val dataLeague = gson.fromJson(
                apiRepository
                    .getRequestAsync(Get.getDetailLeague(query)).await(),
                League::class.java
            )
            view.setInItData(dataLeague.leagues[0])
            view.unSetLoading()
        }
    }

}