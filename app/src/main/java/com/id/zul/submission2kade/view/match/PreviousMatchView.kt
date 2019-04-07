package com.id.zul.submission2kade.view.match

import com.id.zul.submission2kade.model.match.PreviousResults

interface PreviousMatchView {
    fun setLoading()
    fun setInItData(dataMatch: List<PreviousResults>)
    fun unSetLoading()
}