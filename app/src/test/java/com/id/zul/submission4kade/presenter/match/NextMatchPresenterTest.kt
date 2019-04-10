package com.id.zul.submission4kade.presenter.match

import com.google.gson.Gson
import com.id.zul.submission4kade.api.Get
import com.id.zul.submission4kade.api.Request
import com.id.zul.submission4kade.coroutine.TestProviderContext
import com.id.zul.submission4kade.model.match.Match
import com.id.zul.submission4kade.model.match.MatchResults
import com.id.zul.submission4kade.view.match.NextMatchView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NextMatchPresenterTest {

    @Mock
    private lateinit var view: NextMatchView

    @Mock
    private lateinit var presenter: NextMatchPresenter

    @Mock
    private lateinit var apiRepository: Request

    @Mock
    private lateinit var gson: Gson

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        presenter = NextMatchPresenter(view, apiRepository, gson, TestProviderContext())
    }

    @Test
    fun getNextMatch() {
        val matches: MutableList<MatchResults> = mutableListOf()
        val idMatch = "4335"

        GlobalScope.launch {
            Mockito.`when`(
                gson.fromJson(
                    apiRepository
                        .getRequestAsync(Get.getNextMatch(idMatch)).await(),
                    Match::class.java
                )
            ).thenReturn(Match(matches))

            presenter.getNextMatch(idMatch)

            Mockito.verify(view).setLoading()
            Mockito.verify(view).setInItData(matches)
            Mockito.verify(view).unSetLoading()
        }
    }

}