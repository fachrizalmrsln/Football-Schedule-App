package com.id.zul.submission3kade.model.league

import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("leagues")
    var leagues: List<LeagueResults>
)
