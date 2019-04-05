package com.id.zul.submission2kade.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataModel(
    var eventName: String?,
    var imageResource: Int?,
    var description: String?
) : Parcelable