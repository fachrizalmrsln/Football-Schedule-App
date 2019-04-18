package com.id.zul.submission5kade.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.id.zul.submission5kade.R
import com.id.zul.submission5kade.fragment.classement.FragmentClassementContainer
import com.id.zul.submission5kade.fragment.league.FragmentLeagueContainer
import com.id.zul.submission5kade.fragment.match.FragmentMatchContainer
import com.id.zul.submission5kade.fragment.team.FragmentTeamsContainer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setToolbar()
        setBottomNav()
    }

    private fun setToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Football App"
    }

    private fun setBottomNav() {
        bottom_nav_main.setOnNavigationItemSelectedListener { items ->
            when (items.itemId) {

                R.id.nav_matches -> {
                    getMatchView()
                }

                R.id.nav_teams -> {
                    getTeamView()
                }

                R.id.nav_league -> {
                    getLeagueView()
                }

                R.id.nav_classement -> {
                    getClassementView()
                }

            }
            true
        }
        bottom_nav_main.selectedItemId = R.id.nav_matches
    }

    private fun getMatchView() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container_view_main,
                FragmentMatchContainer(), FragmentMatchContainer::class.java.simpleName
            )
            .commit()
    }

    private fun getTeamView() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container_view_main,
                FragmentTeamsContainer(), FragmentTeamsContainer::class.java.simpleName
            )
            .commit()
    }

    private fun getLeagueView() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container_view_main,
                FragmentLeagueContainer(), FragmentLeagueContainer::class.java.simpleName
            )
            .commit()
    }

    private fun getClassementView() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container_view_main,
                FragmentClassementContainer(), FragmentClassementContainer::class.java.simpleName
            )
            .commit()
    }

}
