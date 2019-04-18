package com.id.zul.submission5kade.presenter.match

import com.google.gson.Gson
import com.id.zul.submission5kade.api.Get
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.coroutine.TestProviderContext
import com.id.zul.submission5kade.model.match.Match
import com.id.zul.submission5kade.model.match.MatchResults
import com.id.zul.submission5kade.view.match.MatchDetailView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MatchDetailPresenterTest {

    @Mock
    private lateinit var view: MatchDetailView

    @Mock
    private lateinit var presenter: MatchDetailPresenter

    @Mock
    private lateinit var apiRepository: Request

    @Mock
    private lateinit var gson: Gson

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        presenter = MatchDetailPresenter(view, apiRepository, gson, TestProviderContext())
    }

    @Test
    fun getMatchDetail() {
        val matches: MutableList<MatchResults> = mutableListOf()
        val idMatch = "576806"

        GlobalScope.launch {
            Mockito.`when`(
                gson.fromJson(
                    apiRepository
                        .getRequestAsync(Get.getMatchDetail(idMatch)).await(),
                    Match::class.java
                )
            ).thenReturn(Match(matches))

            presenter.getMatchDetail(idMatch)

            Mockito.verify(view).setLoading()
            Mockito.verify(view).setInItDataMatch(matches[0])
            Mockito.verify(view).unSetLoading()
        }
    }

}