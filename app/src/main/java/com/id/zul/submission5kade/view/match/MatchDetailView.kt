package com.id.zul.submission5kade.view.match

import com.id.zul.submission5kade.model.match.MatchResults
import com.id.zul.submission5kade.model.team.TeamResults

interface MatchDetailView {
    fun setLoading()
    fun setInItDataMatch(dataMatch: MatchResults)
    fun setInItDataTeam(dataTeam: TeamResults, isHomeAway: Boolean)
    fun unSetLoading()
}