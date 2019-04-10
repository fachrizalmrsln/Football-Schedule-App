package com.id.zul.submission4kade.presenter.league

import com.google.gson.Gson
import com.id.zul.submission4kade.api.Get
import com.id.zul.submission4kade.api.Request
import com.id.zul.submission4kade.coroutine.TestProviderContext
import com.id.zul.submission4kade.model.league.League
import com.id.zul.submission4kade.model.league.LeagueResults
import com.id.zul.submission4kade.view.league.LeagueView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LeaguePresenterTest {

    @Mock
    private lateinit var view: LeagueView

    @Mock
    private lateinit var presenter: LeaguePresenter

    @Mock
    private lateinit var apiRepository: Request

    @Mock
    private lateinit var gson: Gson

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        presenter = LeaguePresenter(view, apiRepository, gson, TestProviderContext())
    }

    @Test
    fun getDetailLeague() {
        val leagues: MutableList<LeagueResults> = mutableListOf()
        val idLeague = "4335"

        GlobalScope.launch {
            Mockito.`when`(
                gson.fromJson(
                    apiRepository
                        .getRequestAsync(Get.getDetailLeague(idLeague)).await(),
                    League::class.java
                )
            ).thenReturn(League(leagues))

            presenter.getDetailLeague(idLeague)

            Mockito.verify(view).setLoading()
            Mockito.verify(view).setInItData(leagues[0])
            Mockito.verify(view).unSetLoading()
        }
    }
}