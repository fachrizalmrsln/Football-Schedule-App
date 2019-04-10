package com.id.zul.submission4kade.model.team

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("teams")
    val teams: List<TeamResults>
)
