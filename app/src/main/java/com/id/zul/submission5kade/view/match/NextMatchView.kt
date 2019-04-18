package com.id.zul.submission5kade.view.match

import com.id.zul.submission5kade.model.match.MatchResults

interface NextMatchView {
    fun setLoading()
    fun setInItData(dataMatch: List<MatchResults>)
    fun unSetLoading()
}