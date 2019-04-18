package com.id.zul.submission5kade.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.EditText
import com.google.gson.Gson
import com.id.zul.submission5kade.R
import com.id.zul.submission5kade.adapter.team.TeamsSearchAdapter
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.model.team.TeamResults
import com.id.zul.submission5kade.presenter.team.SearchTeamPresenter
import com.id.zul.submission5kade.view.team.SearchTeamView
import kotlinx.android.synthetic.main.activity_search_team.*

class SearchTeamActivity : AppCompatActivity(), SearchTeamView {

    private var items: MutableList<TeamResults> = mutableListOf()
    private lateinit var searchTeamPresenter: SearchTeamPresenter
    private lateinit var searchTeamAdapter: TeamsSearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_team)

        setToolbar()
        initializePresenter()
        setRecycler()
        setPresenter()

    }

    private fun setToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Searching"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun initializePresenter() {
        val request = Request()
        val gson = Gson()
        searchTeamPresenter = SearchTeamPresenter(this, request, gson)
    }

    private fun setPresenter() {
        searchTeamPresenter.getSearchedTeam(intent.getStringExtra("query"))
    }

    private fun setRecycler() {
        recycler_search_team.layoutManager = GridLayoutManager(this, 2)
        searchTeamAdapter = TeamsSearchAdapter(this, items)
        recycler_search_team.adapter = searchTeamAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_search, menu)

        val searchView = menu?.findItem(R.id.searchMenu)?.actionView as SearchView?

        searchView?.queryHint = "search ..."

        searchView?.findViewById<EditText>(android.support.v7.appcompat.R.id.search_src_text)
            ?.setHintTextColor(Color.WHITE)

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchTeamPresenter.getSearchedTeam(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        return true
    }

    override fun setLoading() {
        items.clear()
        progress_search_team.visibility = View.VISIBLE
        recycler_search_team.visibility = View.GONE
        text_not_found_search_team.visibility = View.GONE
    }

    override fun setInItData(dataSearch: List<TeamResults>) {
        items.addAll(dataSearch)
        searchTeamAdapter.notifyDataSetChanged()
    }

    override fun setNotFound() {
        text_not_found_search_team.visibility = View.VISIBLE
    }

    override fun unSetLoading() {
        progress_search_team.visibility = View.GONE
        recycler_search_team.visibility = View.VISIBLE
    }
}
