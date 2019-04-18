package com.id.zul.submission5kade.presenter.team

import android.content.Context
import com.id.zul.submission5kade.database.FavoriteTeam
import com.id.zul.submission5kade.database.database
import com.id.zul.submission5kade.view.team.FavoriteTeamView
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class FavoriteTeamPresenter(
    private val view: FavoriteTeamView,
    private val context: Context
) {
    fun getData() {
        context.database.use {
            val data = select(FavoriteTeam.TABLE_FAVORITE_TEAM)
            val favoriteTeam = data.parseList(classParser<FavoriteTeam>())

            if (favoriteTeam.isEmpty())
                view.setIsEmpty()
            else {
                view.unSetIsEmpty()
                view.setInsertData(favoriteTeam)
            }
        }
    }

}

