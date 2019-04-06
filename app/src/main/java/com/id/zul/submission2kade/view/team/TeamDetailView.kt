package com.id.zul.submission2kade.view.team

import com.id.zul.submission2kade.model.team.TeamResults

interface TeamDetailView {
    fun setLoading()
    fun setInItData(teamDetail: TeamResults)
    fun unSetLoading()
}