package com.id.zul.submission5kade.presenter.player

import android.util.Log
import com.google.gson.Gson
import com.id.zul.submission5kade.api.Get
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.coroutine.ProviderContext
import com.id.zul.submission5kade.model.player.Players
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
                Players::class.java
            )
            Log.d("Player", data.toString())
            view.setInItData(data.players[0])
            view.unSetLoading()
        }
    }

}