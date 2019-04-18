package com.id.zul.submission5kade.model.league

import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("leagues")
    var leagues: List<LeagueResults>
)
