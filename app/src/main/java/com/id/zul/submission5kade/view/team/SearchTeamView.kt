package com.id.zul.submission5kade.view.team

import com.id.zul.submission5kade.model.team.TeamResults

interface SearchTeamView {
    fun setLoading()
    fun setInItData(dataSearch: List<TeamResults>)
    fun setNotFound()
    fun unSetLoading()
}