package com.id.zul.submission3kade.view.team

import com.id.zul.submission3kade.model.team.TeamResults

interface TeamDetailView {
    fun setLoading()
    fun setInItData(teamDetail: TeamResults)
    fun unSetLoading()
}