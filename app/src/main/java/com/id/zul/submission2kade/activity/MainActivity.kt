package com.id.zul.submission2kade.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.fragment.match.FragmentMatchContainer
import com.id.zul.submission2kade.fragment.team.FragmentTeamsContainer
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
        supportActionBar!!.title = "Football App"
    }

    private fun setBottomNav() {
        bottom_nav.setOnNavigationItemSelectedListener { items ->
            when (items.itemId) {

                R.id.nav_matches -> {
                    getMatchView()
                }

                R.id.nav_teams -> {
                    getTeamView()
                }

            }
            true
        }
        bottom_nav.selectedItemId = R.id.nav_matches
    }

    private fun getMatchView() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container_main_view,
                FragmentMatchContainer(), FragmentMatchContainer::class.java.simpleName
            )
            .commit()
    }

    private fun getTeamView() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container_main_view,
                FragmentTeamsContainer(), FragmentTeamsContainer::class.java.simpleName
            )
            .commit()
    }

}
