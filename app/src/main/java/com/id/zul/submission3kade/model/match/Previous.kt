package com.id.zul.submission3kade.model.match

import com.google.gson.annotations.SerializedName

data class Previous(
    @SerializedName("events")
    var previous: List<PreviousResults>
)