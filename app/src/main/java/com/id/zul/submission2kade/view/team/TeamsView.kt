package com.id.zul.submission2kade.view.team

import com.id.zul.submission2kade.model.team.TeamResults

interface TeamsView {
    fun setLoading()
    fun setInItData(dataTeam: List<TeamResults>)
    fun unSetLoading()
}