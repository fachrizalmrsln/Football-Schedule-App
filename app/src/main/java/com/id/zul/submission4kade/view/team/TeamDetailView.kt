package com.id.zul.submission4kade.view.team

import com.id.zul.submission4kade.model.team.TeamResults

interface TeamDetailView {
    fun setLoading()
    fun setInItData(teamDetail: TeamResults)
    fun unSetLoading()
}