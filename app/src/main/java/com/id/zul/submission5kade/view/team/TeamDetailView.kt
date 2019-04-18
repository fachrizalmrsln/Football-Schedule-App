package com.id.zul.submission5kade.view.team

import com.id.zul.submission5kade.model.team.TeamResults

interface TeamDetailView {
    fun setLoading()
    fun setInItData(teamDetail: TeamResults)
    fun unSetLoading()
}