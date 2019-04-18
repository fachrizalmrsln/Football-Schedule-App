package com.id.zul.submission5kade.view.match

import com.id.zul.submission5kade.model.match.PreviousResults

interface PreviousMatchView {
    fun setLoading()
    fun setInItData(dataMatch: List<PreviousResults>)
    fun unSetLoading()
}