package com.id.zul.submission5kade.view.player

import com.id.zul.submission5kade.model.player.PlayerResults

interface PlayersView {
    fun setLoadingPlayer()
    fun setInItDataPlayer(dataPlayers: List<PlayerResults>)
    fun unSetLoadingPlayer()
}