package com.id.zul.submission5kade.view.player

import com.id.zul.submission5kade.model.player.PlayerResults

interface PlayerDetailView {
    fun setLoading()
    fun setInItData(dataPlayer: PlayerResults)
    fun unSetLoading()
}