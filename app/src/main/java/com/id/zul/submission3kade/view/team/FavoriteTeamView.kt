package com.id.zul.submission3kade.view.team

import com.id.zul.submission3kade.database.FavoriteTeam

interface FavoriteTeamView {
    fun setIsEmpty()
    fun setInsertData(favoriteTeam: List<FavoriteTeam>)
    fun unSetIsEmpty()
}