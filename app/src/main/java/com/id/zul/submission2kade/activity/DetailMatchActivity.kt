package com.id.zul.submission2kade.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.google.gson.Gson
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.api.Request
import com.id.zul.submission2kade.model.match.MatchResults
import com.id.zul.submission2kade.model.team.TeamResults
import com.id.zul.submission2kade.presenter.match.MatchDetailPresenter
import com.id.zul.submission2kade.view.match.MatchDetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*
import java.text.SimpleDateFormat
import java.util.*

class DetailMatchActivity : AppCompatActivity(), MatchDetailView {

    private lateinit var idEvent: String
    private lateinit var homeTeamID: String
    private lateinit var awayTeamID: String
    private lateinit var dateEvent: String
    private lateinit var timeEvent: String
    private lateinit var matchDetailPresenter: MatchDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        setToolbar()
        getValue()
        initializePresenter()

        matchDetailPresenter.getMatchDetail(idEvent)
        matchDetailPresenter.getTeamDetail(homeTeamID, true)
        matchDetailPresenter.getTeamDetail(awayTeamID, false)
    }

    private fun setToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Detail Match"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    private fun getValue() {
        idEvent = intent.getStringExtra("matchID")
        homeTeamID = intent.getStringExtra("homeTeamID")
        awayTeamID = intent.getStringExtra("awayTeamID")
    }

    private fun initializePresenter() {
        val request = Request()
        val gson = Gson()
        matchDetailPresenter = MatchDetailPresenter(this, request, gson)
    }

    @SuppressLint("SimpleDateFormat")
    private fun convertDate(setDate: String) {
        val formatDate = SimpleDateFormat("yyyy-MM-dd")
        formatDate.timeZone = TimeZone.getTimeZone("GMT")
        val date = formatDate.parse(setDate)
        val simpleDateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy")
        dateEvent = simpleDateFormat.format(date)
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    private fun convertTime(setTime: String) {
        val formatTime = SimpleDateFormat("HH:mm:ss")
        formatTime.timeZone = TimeZone.getTimeZone("GMT")
        val time = formatTime.parse(setTime)
        val simpleDateFormat = SimpleDateFormat("kk:mm")
        timeEvent = simpleDateFormat.format(time)
    }

    override fun setLoading() {
        progress_detail.visibility = View.VISIBLE
        scroll_detail.visibility = View.GONE
    }

    @SuppressLint("SetTextI18n")
    override fun setInItDataMatch(dataMatch: MatchResults) {

        text_home_team_detail.text = dataMatch.strHomeTeam
        text_away_team_detail.text = dataMatch.strAwayTeam
        text_league_detail.text = dataMatch.strLeague

        convertDate(dataMatch.dateEvent!!)
        text_date_detail.text = dateEvent

        convertTime(dataMatch.strTime!!)
        text_time_detail.text = "$timeEvent WIB"

        if (dataMatch.intHomeScore.isNullOrEmpty())
            text_score1_detail.text = "-"
        else
            text_score1_detail.text = dataMatch.intHomeScore

        if (dataMatch.intAwayScore.isNullOrEmpty())
            text_score2_detail.text = "-"
        else
            text_score2_detail.text = dataMatch.intAwayScore

        if (dataMatch.strHomeGoalDetails.toString() == "null")
            text_goal_soccer1_detail.text = "-"
        else
            text_goal_soccer1_detail.text = dataMatch.strHomeGoalDetails.toString()

        if (dataMatch.strAwayGoalDetails.toString() == "null")
            text_goal_soccer2_detail.text = "-"
        else
            text_goal_soccer2_detail.text = dataMatch.strAwayGoalDetails.toString()

        if (dataMatch.intHomeShots.toString() == "null")
            text_shoot1_detail.text = "-"
        else
            text_shoot1_detail.text = dataMatch.intHomeShots.toString()

        if (dataMatch.intAwayShots.toString() == "null")
            text_shoot2_detail.text = "-"
        else
            text_shoot2_detail.text = dataMatch.intAwayShots.toString()
    }

    override fun setInItDataTeam(dataTeam: TeamResults, isHomeAway: Boolean) {
        Picasso.get()
            .load(dataTeam.logoTeam)
            .into(
                if (isHomeAway)
                    image_team1_detail
                else
                    image_team2_detail
            )
    }

    override fun unSetLoading() {
        progress_detail.visibility = View.GONE
        scroll_detail.visibility = View.VISIBLE
    }

}
