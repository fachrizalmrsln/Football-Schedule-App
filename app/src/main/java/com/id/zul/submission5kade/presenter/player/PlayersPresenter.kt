package com.id.zul.submission5kade.presenter.player

import com.google.gson.Gson
import com.id.zul.submission5kade.api.Get
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.coroutine.ProviderContext
import com.id.zul.submission5kade.model.player.Player
import com.id.zul.submission5kade.view.player.PlayersView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PlayersPresenter(
    private val view: PlayersView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getPlayers(query: String) {
        view.setLoadingPlayer()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository
                    .getRequestAsync(Get.getPlayer(query)).await(),
                Player::class.java
            )
            view.setInItDataPlayer(data.player)
            view.unSetLoadingPlayer()
        }
    }

}