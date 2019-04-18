package com.id.zul.submission5kade.view.league

import com.id.zul.submission5kade.model.league.LeagueResults

interface LeagueView {
    fun setLoading()
    fun setInItData(dataLeague: LeagueResults)
    fun unSetLoading()
}