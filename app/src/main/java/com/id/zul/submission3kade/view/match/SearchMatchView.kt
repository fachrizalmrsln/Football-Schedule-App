package com.id.zul.submission3kade.view.match

import com.id.zul.submission3kade.model.match.MatchResults

interface SearchMatchView {
    fun setLoading()
    fun setInItData(dataSearch: List<MatchResults>)
    fun unSetLoading()
}