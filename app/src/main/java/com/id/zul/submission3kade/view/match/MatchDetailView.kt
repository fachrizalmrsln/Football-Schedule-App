package com.id.zul.submission3kade.view.match

import com.id.zul.submission3kade.model.match.MatchResults
import com.id.zul.submission3kade.model.team.TeamResults

interface MatchDetailView {
    fun setLoading()
    fun setInItDataMatch(dataMatch: MatchResults)
    fun setInItDataTeam(dataTeam: TeamResults, isHomeAway: Boolean)
    fun unSetLoading()
}