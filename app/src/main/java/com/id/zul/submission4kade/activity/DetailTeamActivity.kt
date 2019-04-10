package com.id.zul.submission4kade.activity

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
import com.id.zul.submission4kade.R
import com.id.zul.submission4kade.api.Request
import com.id.zul.submission4kade.database.FavoriteTeam
import com.id.zul.submission4kade.database.database
import com.id.zul.submission4kade.model.team.FavoriteTeamModel
import com.id.zul.submission4kade.model.team.TeamResults
import com.id.zul.submission4kade.presenter.team.TeamDetailPresenter
import com.id.zul.submission4kade.view.team.TeamDetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_team.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class DetailTeamActivity : AppCompatActivity(), TeamDetailView {

    private lateinit var teamDetailPresenter: TeamDetailPresenter
    private lateinit var favorite: FavoriteTeamModel
    private var isFavoriteOr: Boolean = false
    private var menuItem: Menu? = null

    lateinit var teamID: String
    lateinit var teamName: String
    var teamAka: String? = null
    var teamYear: String? = null
    var teamLeague: String? = null
    var teamCountry: String? = null
    var teamLogo: String? = null
    var teamStadiumIcon: String? = null
    var teamStadiumName: String? = null
    var teamStadiumLocation: String? = null
    var teamDescription: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        getValue()
        setToolbar(teamName)
        initializePresenter(teamID)
    }

    private fun setToolbar(teamName: String) {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = teamName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun initializePresenter(teamID: String) {
        val request = Request()
        val gson = Gson()
        teamDetailPresenter = TeamDetailPresenter(this, request, gson)
        teamDetailPresenter.getTeamDetail(teamID)
    }

    private fun getValue() {
        teamID = intent.getStringExtra("teamID")
        teamName = intent.getStringExtra("teamName")
    }

    override fun setLoading() {
        progress_detail_team.visibility = View.VISIBLE
        scroll_detail_team.visibility = View.GONE
    }

    @SuppressLint("SetTextI18n")
    override fun setInItData(teamDetail: TeamResults) {

        text_team_name_detail_team.text = teamDetail.nameTeam

        if (teamDetail.akaTeam.isNullOrEmpty()) {
            text_team_aka_detail_team.text = "Unknown"
            teamAka = "Unknown"
        } else {
            text_team_aka_detail_team.text = teamDetail.akaTeam
            teamAka = teamDetail.akaTeam
        }

        text_team_year_detail_team.text = teamDetail.yearTeam
        teamYear = teamDetail.yearTeam
        text_team_stadium_name_detail_team.text = teamDetail.nameStadium
        teamStadiumName = teamDetail.nameStadium
        text_team_stadium_location_detail_team.text = teamDetail.locationStadium
        teamStadiumLocation = teamDetail.locationStadium
        text_team_description_detail_team.text = teamDetail.descriptionTeam
        teamDescription = teamDetail.descriptionTeam
        text_team_league_detail_team.text = teamDetail.leagueTeam
        teamLeague = teamDetail.leagueTeam
        text_team_nation_detail_team.text = teamDetail.countryTeam
        teamCountry = teamDetail.countryTeam

        Picasso.get()
            .load(teamDetail.stadiumBackDrop)
            .into(image_stadium_detail_team)
        teamStadiumIcon = teamDetail.stadiumBackDrop

        Picasso.get()
            .load(teamDetail.logoTeam)
            .into(image_logo_detail_team)
        teamLogo = teamDetail.logoTeam

    }

    override fun unSetLoading() {
        progress_detail_team.visibility = View.GONE
        scroll_detail_team.visibility = View.VISIBLE
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

    private fun setOnOffFavorite() {
        if (isFavoriteOr)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.star_on)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.star_off)
    }

    private fun setFavorite() {

        favorite = FavoriteTeamModel(
            teamID,
            teamName,
            teamAka,
            teamYear,
            teamLeague,
            teamCountry,
            teamLogo,
            teamStadiumIcon,
            teamStadiumName,
            teamStadiumLocation,
            teamDescription
        )

        try {
            database.use {
                insert(
                    FavoriteTeam.TABLE_FAVORITE_TEAM,
                    FavoriteTeam.TEAM_ID to teamID,
                    FavoriteTeam.TEAM_NAME to teamName,
                    FavoriteTeam.TEAM_AKA to teamAka,
                    FavoriteTeam.TEAM_YEAR to teamYear,
                    FavoriteTeam.TEAM_LEAGUE to teamLeague,
                    FavoriteTeam.TEAM_COUNTRY to teamCountry,
                    FavoriteTeam.TEAM_LOGO to teamLogo,
                    FavoriteTeam.TEAM_STADIUM_NAME to teamStadiumName,
                    FavoriteTeam.TEAM_STADIUM_LOCATION to teamStadiumLocation,
                    FavoriteTeam.TEAM_STADIUM_ICON to teamStadiumIcon,
                    FavoriteTeam.TEAM_DESCRIPTION to teamDescription
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
                    FavoriteTeam.TABLE_FAVORITE_TEAM,
                    "(TEAM_ID = {id})",
                    "id" to teamID
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
            val result =
                select(FavoriteTeam.TABLE_FAVORITE_TEAM)
                    .whereArgs(
                        "(TEAM_ID = {id})",
                        "id" to teamID
                    )
            val favorite = result.parseList(classParser<FavoriteTeam>())
            if (!favorite.isEmpty())
                isFavoriteOr = true

        }
    }

}
