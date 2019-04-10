package com.id.zul.submission4kade.view.league

import com.id.zul.submission4kade.model.league.LeagueResults

interface LeagueView {
    fun setLoading()
    fun setInItData(dataLeague: LeagueResults)
    fun unSetLoading()
}