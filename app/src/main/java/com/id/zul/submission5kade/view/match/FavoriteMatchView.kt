package com.id.zul.submission5kade.view.match

import com.id.zul.submission5kade.database.FavoriteMatch

interface FavoriteMatchView {
    fun setIsEmpty()
    fun setInsertData(favoriteMatch: List<FavoriteMatch>)
    fun unSetIsEmpty()
}