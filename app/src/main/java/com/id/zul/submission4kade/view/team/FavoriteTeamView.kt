package com.id.zul.submission4kade.view.team

import com.id.zul.submission4kade.database.FavoriteTeam

interface FavoriteTeamView {
    fun setIsEmpty()
    fun setInsertData(favoriteTeam: List<FavoriteTeam>)
    fun unSetIsEmpty()
}