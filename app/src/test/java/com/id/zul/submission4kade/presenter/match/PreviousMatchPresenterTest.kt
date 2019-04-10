package com.id.zul.submission4kade.presenter.match

import com.google.gson.Gson
import com.id.zul.submission4kade.api.Get
import com.id.zul.submission4kade.api.Request
import com.id.zul.submission4kade.coroutine.TestProviderContext
import com.id.zul.submission4kade.model.match.Previous
import com.id.zul.submission4kade.model.match.PreviousResults
import com.id.zul.submission4kade.view.match.PreviousMatchView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class PreviousMatchPresenterTest {

    @Mock
    private lateinit var view: PreviousMatchView

    @Mock
    private lateinit var presenter: PreviousMatchPresenter

    @Mock
    private lateinit var apiRepository: Request

    @Mock
    private lateinit var gson: Gson

    @Before
    fun before() {
        MockitoAnnotations.initMocks(this)
        presenter = PreviousMatchPresenter(view, apiRepository, gson, TestProviderContext())
    }

    @Test
    fun getDetailLeague() {
        val matches: MutableList<PreviousResults> = mutableListOf()
        val idMatch = "4335"

        GlobalScope.launch {
            Mockito.`when`(
                gson.fromJson(
                    apiRepository
                        .getRequestAsync(Get.getPreviousMatch(idMatch)).await(),
                    Previous::class.java
                )
            ).thenReturn(Previous(matches))

            presenter.getPreviousMatch(idMatch)

            Mockito.verify(view).setLoading()
            Mockito.verify(view).setInItData(matches)
            Mockito.verify(view).unSetLoading()
        }
    }
}