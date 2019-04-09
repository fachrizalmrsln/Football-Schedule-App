package com.id.zul.submission3kade.model.match

import com.google.gson.annotations.SerializedName

data class SearchMatch(
    @SerializedName("event")
    var match: List<MatchResults>
)