package com.id.zul.submission2kade.model.match

import com.google.gson.annotations.SerializedName

data class Previous(
    @SerializedName("events")
    var previous: List<PreviousResults>
)
