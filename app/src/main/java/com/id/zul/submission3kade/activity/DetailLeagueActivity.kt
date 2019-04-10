package com.id.zul.submission3kade.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.google.gson.Gson
import com.id.zul.submission3kade.R
import com.id.zul.submission3kade.api.Request
import com.id.zul.submission3kade.model.league.LeagueResults
import com.id.zul.submission3kade.presenter.league.LeaguePresenter
import com.id.zul.submission3kade.view.league.LeagueView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_league.*

class DetailLeagueActivity : AppCompatActivity(), LeagueView {

    private lateinit var idLeague: String
    private lateinit var leaguePresenter: LeaguePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)

        setToolbar()
        initializePresenter()
        covertToId(intent.getStringExtra("leagueName"))

    }

    private fun covertToId(string: String) {
        idLeague = when (string) {
            "English Premier League" -> "4328"
            "English League Championship" -> "4329"
            "German Bundesliga" -> "4331"
            "Italian Serie A" -> "4332"
            "French Ligue 1" -> "4334"
            "Spanish La Liga" -> "4335"
            else -> "4328"
        }
        leaguePresenter.getDetailLeague(idLeague)
    }

    private fun setToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Detail League"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun initializePresenter() {
        val request = Request()
        val gson = Gson()
        leaguePresenter = LeaguePresenter(this, request, gson)
    }

    override fun setLoading() {
        progress_detail_league.visibility = View.VISIBLE
        scroll_detail_league.visibility = View.GONE

    }

    override fun setInItData(dataLeague: LeagueResults) {
        Picasso
            .get()
            .load(dataLeague.strFanart1)
            .into(image_fan_art_detail_league)
        Picasso
            .get()
            .load(dataLeague.strLogo)
            .into(image_logo_detail_league)

        text_league_detail_league.text = dataLeague.strLeague
        text_year_detail_league.text = dataLeague.intFormedYear
        text_country_detail_league.text = dataLeague.strCountry

        Picasso
            .get()
            .load(dataLeague.strPoster)
            .into(image_poster_detail_league)
        Picasso
            .get()
            .load(dataLeague.strTrophy)
            .into(image_trophy_detail_league)

        text_description_detail_league.text = dataLeague.strDescriptionEN
    }

    override fun unSetLoading() {
        progress_detail_league.visibility = View.GONE
        scroll_detail_league.visibility = View.VISIBLE
    }

}
