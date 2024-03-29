package com.id.zul.submission5kade.activity

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
import com.id.zul.submission5kade.R
import com.id.zul.submission5kade.adapter.match.SearchMatchAdapter
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.model.match.MatchResults
import com.id.zul.submission5kade.presenter.match.SearchMatchPresenter
import com.id.zul.submission5kade.view.match.SearchMatchView
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
        searchMatchPresenter.getSearchedMatch(intent.getStringExtra("query"))
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

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchMatchPresenter.getSearchedMatch(query)
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
        progress_search.visibility = View.VISIBLE
        recycler_search.visibility = View.GONE
        text_not_found_search.visibility = View.GONE
    }

    override fun setInItData(dataSearch: List<MatchResults>) {
        items.addAll(dataSearch)
        searchMachAdapter.notifyDataSetChanged()
    }

    override fun setNotFound() {
        text_not_found_search.visibility = View.VISIBLE
    }

    override fun unSetLoading() {
        progress_search.visibility = View.GONE
        recycler_search.visibility = View.VISIBLE
    }

}
