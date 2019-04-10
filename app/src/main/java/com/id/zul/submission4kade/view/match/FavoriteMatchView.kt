package com.id.zul.submission4kade.view.match

import com.id.zul.submission4kade.database.FavoriteMatch

interface FavoriteMatchView {
    fun setIsEmpty()
    fun setInsertData(favoriteMatch: List<FavoriteMatch>)
    fun unSetIsEmpty()
}