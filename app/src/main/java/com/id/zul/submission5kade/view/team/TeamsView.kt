package com.id.zul.submission5kade.view.team

import com.id.zul.submission5kade.model.team.TeamResults

interface TeamsView {
    fun setLoadingTeam()
    fun setInItData(dataTeam: List<TeamResults>)
    fun unSetLoadingTeam()
}