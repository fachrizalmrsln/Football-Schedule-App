package com.id.zul.submission3kade.view.match

import com.id.zul.submission3kade.model.match.PreviousResults

interface PreviousMatchView {
    fun setLoading()
    fun setInItData(dataMatch: List<PreviousResults>)
    fun unSetLoading()
}