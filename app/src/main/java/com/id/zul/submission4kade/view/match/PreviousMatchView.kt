package com.id.zul.submission4kade.view.match

import com.id.zul.submission4kade.model.match.PreviousResults

interface PreviousMatchView {
    fun setLoading()
    fun setInItData(dataMatch: List<PreviousResults>)
    fun unSetLoading()
}