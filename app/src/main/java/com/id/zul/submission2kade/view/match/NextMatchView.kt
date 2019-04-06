package com.id.zul.submission2kade.view.match

import com.id.zul.submission2kade.model.match.MatchResults

interface NextMatchView {
    fun setLoading()
    fun setInItData(dataMatch: List<MatchResults>)
    fun unSetLoading()
}