package com.id.zul.submission5kade.presenter.player

import com.google.gson.Gson
import com.id.zul.submission5kade.api.Get
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.coroutine.ProviderContext
import com.id.zul.submission5kade.model.player.Player
import com.id.zul.submission5kade.view.player.PlayerDetailView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PlayerDetailPresenter(
    private val view: PlayerDetailView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getPlayerDetail(query: String) {
        view.setLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(
                apiRepository
                    .getRequestAsync(Get.getPlayerDetails(query)).await(),
                Player::class.java
            )
            view.setInItData(data.player)
            view.unSetLoading()
        }
    }

}