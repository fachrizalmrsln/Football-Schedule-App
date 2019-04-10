package com.id.zul.submission3kade.view.league

import com.id.zul.submission3kade.model.league.LeagueResults

interface LeagueView {
    fun setLoading()
    fun setInItData(dataLeague: LeagueResults)
    fun unSetLoading()
}