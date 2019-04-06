package com.id.zul.submission2kade.model.team

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("teams")
    val teams: List<TeamResults>
)
