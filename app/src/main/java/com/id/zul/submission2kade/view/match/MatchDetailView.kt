package com.id.zul.submission2kade.view.match

import com.id.zul.submission2kade.model.match.MatchResults
import com.id.zul.submission2kade.model.team.TeamResults

interface MatchDetailView {
    fun setLoading()
    fun setInItDataMatch(dataMatch: MatchResults)
    fun setInItDataTeam(dataTeam: TeamResults, isHomeAway: Boolean)
    fun unSetLoading()
}