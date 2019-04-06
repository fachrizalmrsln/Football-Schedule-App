package com.id.zul.submission2kade.view.league

import com.id.zul.submission2kade.model.league.LeagueResults

interface LeagueView {
    fun setLoading()
    fun setInItData(dataLeague: List<LeagueResults>)
    fun unSetLoading()
}