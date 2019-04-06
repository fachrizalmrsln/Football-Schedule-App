package com.id.zul.submission2kade.model.match

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("events")
    var match: List<MatchResults>
)
