package com.id.zul.submission3kade.view.team

import com.id.zul.submission3kade.model.team.TeamResults

interface TeamsView {
    fun setLoading()
    fun setInItData(dataTeam: List<TeamResults>)
    fun unSetLoading()
}