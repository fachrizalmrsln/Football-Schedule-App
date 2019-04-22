package com.id.zul.submission5kade.activity

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.gson.Gson
import com.id.zul.submission5kade.R
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.database.FavoriteMatch
import com.id.zul.submission5kade.database.database
import com.id.zul.submission5kade.model.match.FavoriteMatchModel
import com.id.zul.submission5kade.model.match.MatchResults
import com.id.zul.submission5kade.model.team.TeamResults
import com.id.zul.submission5kade.presenter.match.MatchDetailPresenter
import com.id.zul.submission5kade.utils.Utils
import com.id.zul.submission5kade.view.match.MatchDetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class DetailMatchActivity : AppCompatActivity(), MatchDetailView {

    private lateinit var idEvent: String
    private lateinit var homeTeamID: String
    private lateinit var awayTeamID: String
    private lateinit var timeEvent: String
    private lateinit var favorite: FavoriteMatchModel
    private lateinit var matchDetailPresenter: MatchDetailPresenter
    private var isFavoriteOr: Boolean = false
    private var menuItem: Menu? = null

    private var idMatch: String? = null
    private var homeTeam: String? = null
    private var awayTeam: String? = null
    private var homeLogo: String? = null
    private var awayLogo: String? = null
    private var league: String? = null
    private var date: String? = null
    private var time: String? = null
    private var homeScore: String? = null
    private var awayScore: String? = null
    private var homeGoalSoccer: String? = null
    private var awayGoalSoccer: String? = null
    private var homeShoot: String? = null
    private var awayShoot: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)

        setToolbar()
        getValue()
        initializePresenter()
        setPresenter()

    }

    override fun setLoading() {
        progress_detail_match.visibility = View.VISIBLE
        scroll_detail_match.visibility = View.GONE
    }

    @SuppressLint("SetTextI18n")
    override fun setInItDataMatch(dataMatch: MatchResults) {

        idMatch = idEvent

        text_home_team_detail_match.text = dataMatch.strHomeTeam
        homeTeam = dataMatch.strHomeTeam

        text_away_team_detail_match.text = dataMatch.strAwayTeam
        awayTeam = dataMatch.strAwayTeam

        text_league_detail_match.text = dataMatch.strLeague
        league = dataMatch.strLeague

        date = dataMatch.dateEvent.let { it?.let { it1 -> Utils.formatToDate(it1) } }
        text_date_detail_match.text = date.toString()

        dataMatch.strTime?.let { convertTime(it) }
        text_time_detail_match.text = "$timeEvent WIB"
        time = timeEvent

        if (dataMatch.intHomeScore.isNullOrEmpty()) {
            text_score1_detail_match.text = "-"
            homeScore = "-"
        } else {
            text_score1_detail_match.text = dataMatch.intHomeScore
            homeScore = dataMatch.intHomeScore
        }

        if (dataMatch.intAwayScore.isNullOrEmpty()) {
            text_score2_detail_match.text = "-"
            awayScore = "-"
        } else {
            text_score2_detail_match.text = dataMatch.intAwayScore
            awayScore = dataMatch.intAwayScore
        }

        when {
            dataMatch.strHomeGoalDetails.toString() == "null" -> {
                text_goal_soccer1_detail_match.text = "-"
                homeGoalSoccer = "-"
            }
            dataMatch.strHomeGoalDetails.toString() == "" -> {
                text_goal_soccer1_detail_match.text = "-"
                homeGoalSoccer = "-"
            }
            else -> {
                text_goal_soccer1_detail_match.text = dataMatch.strHomeGoalDetails.toString()
                homeGoalSoccer = dataMatch.strHomeGoalDetails.toString()
            }
        }

        when {
            dataMatch.strAwayGoalDetails.toString() == "null" -> {
                awayGoalSoccer = "-"
                text_goal_soccer2_detail_match.text = "-"
            }
            dataMatch.strAwayGoalDetails.toString() == "" -> {
                awayGoalSoccer = "="
                text_goal_soccer2_detail_match.text = "-"
            }
            else -> {
                awayGoalSoccer = dataMatch.strAwayGoalDetails.toString()
                text_goal_soccer2_detail_match.text = dataMatch.strAwayGoalDetails.toString()
            }
        }

        when {
            dataMatch.intHomeShots.toString() == "null" -> {
                homeShoot = "-"
                text_shoot1_detail_match.text = "-"
            }
            dataMatch.intHomeShots.toString() == "0" -> {
                homeShoot = "-"
                text_shoot1_detail_match.text = "-"
            }
            else -> {
                homeShoot = dataMatch.intHomeShots.toString()
                text_shoot1_detail_match.text = dataMatch.intHomeShots.toString()
            }
        }

        when {
            dataMatch.intAwayShots.toString() == "null" -> {
                awayShoot = "-"
                text_shoot2_detail_match.text = "-"
            }
            dataMatch.intAwayShots.toString() == "0" -> {
                awayShoot = "-"
                text_shoot2_detail_match.text = "-"
            }
            else -> {
                awayShoot = dataMatch.intAwayShots.toString()
                text_shoot2_detail_match.text = dataMatch.intAwayShots.toString()
            }
        }

    }

    override fun setInItDataTeam(dataTeam: TeamResults, isHomeAway: Boolean) {
        Picasso.get()
            .load(dataTeam.logoTeam)
            .into(
                if (isHomeAway)
                    image_team1_detail_match
                else
                    image_team2_detail_match
            )

        if (isHomeAway)
            homeLogo = dataTeam.logoTeam
        else
            awayLogo = dataTeam.logoTeam

    }

    override fun unSetLoading() {
        progress_detail_match.visibility = View.GONE
        scroll_detail_match.visibility = View.VISIBLE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        menuItem = menu
        favoriteState()
        setOnOffFavorite()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.favoriteMenu -> {
                if (isFavoriteOr)
                    unSetFavorite()
                else
                    setFavorite()

                setOnOffFavorite()
                true
            }
            else ->
                return super.onOptionsItemSelected(item)
        }

    }

    private fun setToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Detail Match"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
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

    private fun setPresenter() {
        matchDetailPresenter.getMatchDetail(idEvent)
        matchDetailPresenter.getTeamDetail(homeTeamID, true)
        matchDetailPresenter.getTeamDetail(awayTeamID, false)
    }

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    private fun convertTime(setTime: String) {
        val formatTime = SimpleDateFormat("HH:mm:ss")
        formatTime.timeZone = TimeZone.getTimeZone("GMT")
        val time = formatTime.parse(setTime)
        val simpleDateFormat = SimpleDateFormat("kk:mm")
        timeEvent = simpleDateFormat.format(time)
    }

    private fun setOnOffFavorite() {
        if (isFavoriteOr)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.star_on)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.star_off)
    }

    private fun setFavorite() {

        favorite = FavoriteMatchModel(
            idMatch,
            homeTeam,
            awayTeam,
            homeLogo,
            awayLogo,
            league,
            date,
            time,
            homeScore,
            awayScore,
            homeGoalSoccer,
            awayGoalSoccer,
            homeShoot,
            awayShoot
        )

        try {
            database.use {
                insert(
                    FavoriteMatch.TABLE_FAVORITE_MATCH,
                    FavoriteMatch.MATCH_ID to idMatch,
                    FavoriteMatch.MATCH_HOME_TEAM to homeTeam,
                    FavoriteMatch.MATCH_AWAY_TEAM to awayTeam,
                    FavoriteMatch.MATCH_HOME_LOGO to homeLogo,
                    FavoriteMatch.MATCH_AWAY_LOGO to awayLogo,
                    FavoriteMatch.MATCH_LEAGUE to league,
                    FavoriteMatch.MATCH_DATE to date,
                    FavoriteMatch.MATCH_TIME to time,
                    FavoriteMatch.MATCH_HOME_SCORE to homeScore,
                    FavoriteMatch.MATCH_AWAY_SOCCER to awayScore,
                    FavoriteMatch.MATCH_HOME_SOCCER to homeGoalSoccer,
                    FavoriteMatch.MATCH_HOME_SHOOT to homeGoalSoccer,
                    FavoriteMatch.MATCH_AWAY_SHOOT to awayGoalSoccer
                )
            }
            toast("Add To Favorite !")
            isFavoriteOr = true
        } catch (e: SQLiteConstraintException) {
            toast(e.localizedMessage).show()
        }
    }

    private fun unSetFavorite() {
        try {
            database.use {
                delete(
                    FavoriteMatch.TABLE_FAVORITE_MATCH,
                    "(MATCH_ID = {id})",
                    "id" to idEvent
                )
            }
            toast("Remove From Favorite !")
            isFavoriteOr = false
        } catch (e: SQLiteConstraintException) {
            longToast(e.localizedMessage)
        }
    }

    private fun favoriteState() {
        database.use {
            val result = select(FavoriteMatch.TABLE_FAVORITE_MATCH)
                .whereArgs(
                    "(MATCH_ID = {id})",
                    "id" to idEvent
                )
            val favorite = result.parseList(classParser<FavoriteMatch>())
            if (!favorite.isEmpty())
                isFavoriteOr = true

        }
    }

}
