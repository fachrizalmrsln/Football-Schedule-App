package com.id.zul.submission5kade.model.match

import com.google.gson.annotations.SerializedName

data class SearchMatch(
    @SerializedName("event")
    var match: List<MatchResults>
)