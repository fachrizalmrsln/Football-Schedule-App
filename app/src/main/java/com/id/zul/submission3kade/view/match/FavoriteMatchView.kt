package com.id.zul.submission3kade.view.match

import com.id.zul.submission3kade.database.FavoriteMatch

interface FavoriteMatchView {
    fun setIsEmpty()
    fun setInsertData(favoriteMatch: List<FavoriteMatch>)
    fun unSetIsEmpty()
}