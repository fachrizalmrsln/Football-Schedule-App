package com.id.zul.submission2kade.view.match

import com.id.zul.submission2kade.model.match.MatchResults

interface SearchMatchView {
    fun setLoading()
    fun setInItData(dataSearch: List<MatchResults>)
    fun unSetLoading()
}