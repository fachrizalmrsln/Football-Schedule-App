package com.id.zul.submission2kade.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.fragment.FragmentMatch
import com.id.zul.submission2kade.fragment.FragmentTeam
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()

        bottom_nav.selectedItemId = R.id.nav_matches
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

    }

    private fun getMatchView() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.viewer_main, FragmentMatch(), FragmentMatch::class.java.simpleName)
            .commit()
    }

    private fun getTeamView() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.viewer_main, FragmentTeam(), FragmentTeam::class.java.simpleName)
            .commit()
    }

    private fun initToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Football Schedule App"
    }

}
