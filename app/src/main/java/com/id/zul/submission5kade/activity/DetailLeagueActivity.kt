package com.id.zul.submission5kade.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.google.gson.Gson
import com.id.zul.submission5kade.R
import com.id.zul.submission5kade.adapter.classement.ClassementAdapter
import com.id.zul.submission5kade.adapter.team.TeamsSmallAdapter
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.model.classement.ClassementResults
import com.id.zul.submission5kade.model.league.LeagueResults
import com.id.zul.submission5kade.model.team.TeamResults
import com.id.zul.submission5kade.presenter.classement.ClassementPresenter
import com.id.zul.submission5kade.presenter.league.LeaguePresenter
import com.id.zul.submission5kade.presenter.team.TeamsPresenter
import com.id.zul.submission5kade.view.classement.ClassementView
import com.id.zul.submission5kade.view.league.LeagueView
import com.id.zul.submission5kade.view.team.TeamsView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_league.*

class DetailLeagueActivity : AppCompatActivity(), LeagueView, TeamsView, ClassementView {

    private lateinit var idLeague: String
    private lateinit var leaguePresenter: LeaguePresenter
    private lateinit var teamsPresenter: TeamsPresenter
    private lateinit var classementPresenter: ClassementPresenter
    private lateinit var adapter: TeamsSmallAdapter
    private lateinit var adapterClassement: ClassementAdapter
    private var items: MutableList<TeamResults> = mutableListOf()
    private var itemsClassement: MutableList<ClassementResults> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)

        setToolbar()
        setRecycler()
        initializePresenter()
        covertToId(intent.getStringExtra("leagueName"))
        teamsPresenter.getLeagueList(intent.getStringExtra("leagueName"))

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
        classementPresenter.getClassement(idLeague)
    }

    private fun setToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Detail League"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun setRecycler() {
        recycler_team_detail_league.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter = TeamsSmallAdapter(this, items)
        recycler_team_detail_league.adapter = adapter

        recycler_classement_detail_league.layoutManager = LinearLayoutManager(this)
        adapterClassement = ClassementAdapter(itemsClassement)
        recycler_classement_detail_league.adapter = adapterClassement
    }

    private fun initializePresenter() {
        val request = Request()
        val gson = Gson()
        leaguePresenter = LeaguePresenter(this, request, gson)
        teamsPresenter = TeamsPresenter(this, request, gson)
        classementPresenter = ClassementPresenter(this, request, gson)
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

    override fun setLoadingTeam() {
        progress_team_detail_league.visibility = View.VISIBLE
        recycler_team_detail_league.visibility = View.GONE
    }

    override fun setInItData(dataTeam: List<TeamResults>) {
        items.clear()
        items.addAll(dataTeam)
        adapter.notifyDataSetChanged()
    }

    override fun unSetLoadingTeam() {
        progress_team_detail_league.visibility = View.GONE
        recycler_team_detail_league.visibility = View.VISIBLE
    }

    override fun setLoadingClassement() {
        progress_classement_detail_league.visibility = View.VISIBLE
        card_classement_detail_league.visibility = View.GONE
    }

    override fun setInItDataClassement(dataClassement: List<ClassementResults>) {
        itemsClassement.clear()
        itemsClassement.addAll(dataClassement)
        adapterClassement.notifyDataSetChanged()
    }

    override fun unSetLoadingClassement() {
        progress_classement_detail_league.visibility = View.GONE
        card_classement_detail_league.visibility = View.VISIBLE
    }

}
