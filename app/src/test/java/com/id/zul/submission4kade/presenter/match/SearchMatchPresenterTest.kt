package com.id.zul.submission4kade.presenter.match

import com.google.gson.Gson
import com.id.zul.submission4kade.api.Get
import com.id.zul.submission4kade.api.Request
import com.id.zul.submission4kade.coroutine.TestProviderContext
import com.id.zul.submission4kade.model.match.Match
import com.id.zul.submission4kade.model.match.MatchResults
import com.id.zul.submission4kade.view.match.SearchMatchView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SearchMatchPresenterTest {

    @Mock
    private lateinit var view: SearchMatchView

    @Mock
    private lateinit var presenter: SearchMatchPresenter

    @Mock
    private lateinit var apiRepository: Request

    @Mock
    private lateinit var gson: Gson

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        presenter = SearchMatchPresenter(view, apiRepository, gson, TestProviderContext())
    }

    @Test
    fun getSearchMatch() {
        val matches: MutableList<MatchResults> = mutableListOf()
        val query = "Arsenal"

        GlobalScope.launch {
            Mockito.`when`(
                gson.fromJson(
                    apiRepository
                        .getRequestAsync(Get.getSearchMatch(query)).await(),
                    Match::class.java
                )
            ).thenReturn(Match(matches))

            presenter.getNextMatch(query)

            Mockito.verify(view).setLoading()
            Mockito.verify(view).setInItData(matches)
            Mockito.verify(view).unSetLoading()
        }
    }

}