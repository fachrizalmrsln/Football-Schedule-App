package com.id.zul.submission3kade.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.id.zul.submission3kade.R
import com.id.zul.submission3kade.fragment.match.FragmentMatchContainer
import com.id.zul.submission3kade.fragment.team.FragmentTeamsContainer
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

}
