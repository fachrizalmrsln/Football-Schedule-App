package com.id.zul.submission5kade.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import com.google.gson.Gson
import com.id.zul.submission5kade.R
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.model.player.PlayerResults
import com.id.zul.submission5kade.presenter.player.PlayerDetailPresenter
import com.id.zul.submission5kade.view.player.PlayerDetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_player.*

class DetailPlayerActivity : AppCompatActivity(), PlayerDetailView {

    private lateinit var playerDetailPresenter: PlayerDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_player)

        setToolbar()
        initializePresenter()
        getData(intent.getStringExtra("playerID"))
    }

    private fun setToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Detail Player"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun initializePresenter() {
        val request = Request()
        val gson = Gson()
        playerDetailPresenter = PlayerDetailPresenter(this, request, gson)
    }

    private fun getData(playerID: String) {
        playerDetailPresenter.getPlayerDetail(playerID)
    }

    override fun setLoading() {
        progress_detail_player.visibility = View.VISIBLE
        container_detail_player.visibility = View.GONE
    }

    override fun setInItData(dataPlayer: PlayerResults) {
        text_player_name_detail.text = dataPlayer.strPlayer
        text_player_nationality_detail.text = dataPlayer.strNationality
        text_player_born_detail.text = dataPlayer.dateBorn
        text_player_birth_location_detail.text = dataPlayer.strBirthLocation
        text_player_height_detail.text = dataPlayer.strHeight
        text_player_weight_detail.text = dataPlayer.strWeight

        Picasso
            .get()
            .load(dataPlayer.strThumb)
            .into(image_player_detail)

        Picasso
            .get()
            .load(dataPlayer.strFanart1)
            .into(image_player_fan_art_detail)

        text_player_team_detail.text = dataPlayer.strTeam
        text_player_position_detail.text = dataPlayer.strPosition
    }

    override fun unSetLoading() {
        progress_detail_player.visibility = View.GONE
        container_detail_player.visibility = View.VISIBLE
    }
}
