package com.id.zul.submission2kade.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.id.zul.submission2kade.R
import kotlinx.android.synthetic.main.activity_detail_match.*
import java.text.SimpleDateFormat
import java.util.*

class DetailMatchActivity : AppCompatActivity() {

    private lateinit var idEvent: String
    private lateinit var homeTeam: String
    private lateinit var awayTeam: String
    private lateinit var league: String
    private lateinit var dateEvent: String
    private lateinit var timeEvent: String
    private lateinit var goalHome: String
    private lateinit var goalAway: String
    private lateinit var soccerHome: String
    private lateinit var soccerAway: String
    private lateinit var shootHome: String
    private lateinit var shootAway: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        setToolbar()
        getValue()
        inItText()

    }

    private fun setToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Detail Match"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

    private fun getValue() {

        idEvent = intent.getStringExtra("match")

        homeTeam = intent.getStringExtra("homeTeam")
        awayTeam = intent.getStringExtra("awayTeam")

        league = intent.getStringExtra("league")

        dateEvent = intent.getStringExtra("date")
        timeEvent = intent.getStringExtra("time")

        goalHome = intent.getStringExtra("goalHome")
        goalAway = intent.getStringExtra("goalAway")

        soccerHome = intent.getStringExtra("soccerHome")
        soccerAway = intent.getStringExtra("soccerAway")

        shootHome = intent.getStringExtra("shootHome")
        shootAway = intent.getStringExtra("shootAway")

    }

    @SuppressLint("SetTextI18n")
    private fun inItText() {

        text_home_team_detail.text = homeTeam
        text_away_team_detail.text = awayTeam

        text_league_detail.text = league

        convertDate()
        text_date_detail.text = dateEvent
        convertTime()
        text_time_detail.text = "$timeEvent WIB"

        text_score1_detail.text = goalHome
        text_score2_detail.text = goalAway

        text_goal_soccer1_detail.text = soccerHome
        text_goal_soccer2_detail.text = soccerAway

        text_shoot1_detail.text = shootHome
        text_shoot2_detail.text = shootAway

    }

    @SuppressLint("SimpleDateFormat")
    private fun convertDate() {
        val formatDate = SimpleDateFormat("yyyy-MM-dd")
        formatDate.timeZone = TimeZone.getTimeZone("GMT")
        val date = formatDate.parse(dateEvent)
        val simpleDateFormat = SimpleDateFormat("EEEE, dd MMMM")
        dateEvent = simpleDateFormat.format(date)
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    private fun convertTime() {
        val formatTime = SimpleDateFormat("HH:mm:ss")
        formatTime.timeZone = TimeZone.getTimeZone("GMT")
        val time = formatTime.parse(timeEvent)
        val simpleDateFormat = SimpleDateFormat("kk:mm")
        timeEvent = simpleDateFormat.format(time)
    }

}
