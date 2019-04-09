package com.id.zul.submission3kade.model.match

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("events")
    var match: List<MatchResults>
)
