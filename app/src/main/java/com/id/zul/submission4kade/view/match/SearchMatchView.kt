package com.id.zul.submission4kade.view.match

import com.id.zul.submission4kade.model.match.MatchResults

interface SearchMatchView {
    fun setLoading()
    fun setInItData(dataSearch: List<MatchResults>)
    fun setNotFound()
    fun unSetLoading()
}