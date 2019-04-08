package com.id.zul.submission2kade.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.gson.Gson
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.api.Request
import com.id.zul.submission2kade.model.team.TeamResults
import com.id.zul.submission2kade.presenter.team.TeamDetailPresenter
import com.id.zul.submission2kade.view.team.TeamDetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_team.*
import org.jetbrains.anko.toast

class DetailTeamActivity : AppCompatActivity(), TeamDetailView {

    private lateinit var teamID: String
    private lateinit var teamName: String
    private lateinit var teamDetailPresenter: TeamDetailPresenter
    private var isFavoriteOr: Boolean = false
    private var menuItem: Menu? = null

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

        if (teamDetail.akaTeam.isNullOrEmpty())
            text_team_aka_detail_team.text = "Unknown"
        else
            text_team_aka_detail_team.text = teamDetail.akaTeam

        text_team_year_detail_team.text = teamDetail.yearTeam
        text_team_stadium_name_detail_team.text = teamDetail.nameStadium
        text_team_stadium_location_detail_team.text = teamDetail.locationStadium
        text_team_description_detail_team.text = teamDetail.descriptionTeam
        text_team_league_detail_team.text = teamDetail.leagueTeam
        text_team_nation_detail_team.text = teamDetail.countryTeam

        Picasso.get()
            .load(teamDetail.stadiumBackDrop)
            .into(image_stadium_detail_team)

        Picasso.get()
            .load(teamDetail.logoTeam)
            .into(image_logo_detail_team)
    }

    override fun unSetLoading() {
        progress_detail_team.visibility = View.GONE
        scroll_detail_team.visibility = View.VISIBLE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_favorite, menu)
        menuItem = menu
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
        toast("Add To Favorite !")
        isFavoriteOr = true
    }

    private fun unSetFavorite() {
        toast("Remove From Favorite !")
        isFavoriteOr = false
    }

}
