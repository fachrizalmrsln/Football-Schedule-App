package com.id.zul.submission5kade.view.team

import com.id.zul.submission5kade.database.FavoriteTeam

interface FavoriteTeamView {
    fun setIsEmpty()
    fun setInsertData(favoriteTeam: List<FavoriteTeam>)
    fun unSetIsEmpty()
}