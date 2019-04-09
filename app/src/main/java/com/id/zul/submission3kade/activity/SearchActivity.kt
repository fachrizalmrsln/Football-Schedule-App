package com.id.zul.submission3kade.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.EditText
import com.google.gson.Gson
import com.id.zul.submission3kade.R
import com.id.zul.submission3kade.adapter.match.SearchMatchAdapter
import com.id.zul.submission3kade.api.Request
import com.id.zul.submission3kade.model.match.MatchResults
import com.id.zul.submission3kade.presenter.match.SearchMatchPresenter
import com.id.zul.submission3kade.view.match.SearchMatchView
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), SearchMatchView {

    private var items: MutableList<MatchResults> = mutableListOf()
    private lateinit var searchMatchPresenter: SearchMatchPresenter
    private lateinit var searchMachAdapter: SearchMatchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

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
        searchMatchPresenter = SearchMatchPresenter(this, request, gson)
    }

    private fun setPresenter() {
        searchMatchPresenter.getNextMatch(intent.getStringExtra("query"))
    }

    private fun setRecycler() {
        recycler_search.layoutManager = LinearLayoutManager(this)
        searchMachAdapter = SearchMatchAdapter(this, items)
        recycler_search.adapter = searchMachAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu_search, menu)

        val searchView = menu?.findItem(R.id.searchMenu)?.actionView as SearchView?

        searchView?.queryHint = "search ..."

        searchView?.findViewById<EditText>(android.support.v7.appcompat.R.id.search_src_text)
            ?.setHintTextColor(Color.WHITE)

        searchView?.setOnQueryTextListener(object : android.support.v7.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchMatchPresenter.getNextMatch(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

        return true
    }

    override fun setLoading() {
        progress_search.visibility = View.VISIBLE
        recycler_search.visibility = View.GONE
    }

    override fun setInItData(dataSearch: List<MatchResults>) {
        items.clear()
        items.addAll(dataSearch)
        searchMachAdapter.notifyDataSetChanged()
    }

    override fun unSetLoading() {
        progress_search.visibility = View.GONE
        recycler_search.visibility = View.VISIBLE
    }


}
