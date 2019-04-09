package com.id.zul.submission3kade.presenter.match

import android.content.Context
import com.id.zul.submission3kade.database.FavoriteMatch
import com.id.zul.submission3kade.database.database
import com.id.zul.submission3kade.view.match.FavoriteMatchView
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class FavoriteMatchPresenter(
    private val view: FavoriteMatchView,
    private val context: Context
) {
    fun getData() {
        context.database.use {
            val data = select(FavoriteMatch.TABLE_FAVORITE_MATCH)
            val favoriteMatch = data.parseList(classParser<FavoriteMatch>())

            if (favoriteMatch.isEmpty())
                view.setIsEmpty()
            else {
                view.unSetIsEmpty()
                view.setInsertData(favoriteMatch)
            }
        }
    }

}

