package com.id.zul.submission4kade.view.match

import com.id.zul.submission4kade.model.match.MatchResults
import com.id.zul.submission4kade.model.team.TeamResults

interface MatchDetailView {
    fun setLoading()
    fun setInItDataMatch(dataMatch: MatchResults)
    fun setInItDataTeam(dataTeam: TeamResults, isHomeAway: Boolean)
    fun unSetLoading()
}