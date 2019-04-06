package com.id.zul.submission2kade.model.league

import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("teams")
    val league: List<LeagueResults>
)
