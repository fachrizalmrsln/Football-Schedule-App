package com.id.zul.submission4kade.view.team

import com.id.zul.submission4kade.model.team.TeamResults

interface TeamsView {
    fun setLoading()
    fun setInItData(dataTeam: List<TeamResults>)
    fun unSetLoading()
}