package com.id.zul.submission2kade.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.google.gson.Gson
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.api.Request
import com.id.zul.submission2kade.model.team.TeamResults
import com.id.zul.submission2kade.presenter.team.TeamDetailPresenter
import com.id.zul.submission2kade.view.team.TeamDetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_league.*

class DetailTeamActivity : AppCompatActivity(), TeamDetailView {

    private lateinit var teamID: String
    private lateinit var teamName: String
    private lateinit var teamDetailPresenter: TeamDetailPresenter
    private lateinit var teams: TeamResults

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)

        teamID = intent.getStringExtra("teamID")
        teamName = intent.getStringExtra("teamName")

        setToolbar(teamName)
        initializePresenter(teamID)
    }

    private fun setToolbar(teamName: String) {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = teamName
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    private fun initializePresenter(teamID: String) {
        val request = Request()
        val gson = Gson()
        teamDetailPresenter = TeamDetailPresenter(this, request, gson)
        teamDetailPresenter.getTeamDetail(teamID)
    }

    override fun setLoading() {
        progress_detail.visibility = View.VISIBLE
        scroll_detail.visibility = View.GONE
    }

    override fun setInItData(teamDetail: TeamResults) {
        teams = TeamResults(
            teamDetail.idTeam,
            teamDetail.nameTeam,
            teamDetail.logoTeam,
            teamDetail.akaTeam,
            teamDetail.yearTeam,
            teamDetail.nameStadium,
            teamDetail.stadiumBackDrop,
            teamDetail.locationStadium,
            teamDetail.descriptionTeam,
            teamDetail.leagueTeam,
            teamDetail.countryTeam
        )

        text_team_name_template.text = teamDetail.nameTeam
        text_team_aka_template.text = teamDetail.akaTeam
        text_team_year_template.text = teamDetail.yearTeam
        text_team_stadium_name_template.text = teamDetail.nameStadium
        text_team_stadium_location_template.text = teamDetail.locationStadium
        text_team_description_template.text = teamDetail.descriptionTeam
        text_team_league_template.text = teamDetail.leagueTeam
        text_team_nation_template.text = teamDetail.countryTeam

        Picasso.get()
            .load(teamDetail.stadiumBackDrop)
            .into(image_stadium_template)

        Picasso.get()
            .load(teamDetail.logoTeam)
            .into(image_logo_template)
    }

    override fun unSetLoading() {
        progress_detail.visibility = View.GONE
        scroll_detail.visibility = View.VISIBLE
    }

}
