package com.id.zul.submission2kade.fragment.league

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Spinner
import com.google.gson.Gson
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.adapter.league.LeagueAdapter
import com.id.zul.submission2kade.api.Request
import com.id.zul.submission2kade.model.league.LeagueResults
import com.id.zul.submission2kade.presenter.league.LeaguePresenter
import com.id.zul.submission2kade.view.league.LeagueView

class FragmentLeagueContainer : Fragment(), LeagueView {

    private var items: MutableList<LeagueResults> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LeagueAdapter
    private lateinit var leaguePresenter: LeaguePresenter
    private lateinit var spinner: Spinner
    private lateinit var spinnerItems: Array<String>
    private lateinit var spinnerAdapter: ArrayAdapter<String>
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater
            .inflate(R.layout.fragment_league_container, container, false)

        signInViews(view)
        initializePresenter()
        setRecycler()
        setSpinner()

        return view
    }

    private fun signInViews(view: View) {
        progressBar = view.findViewById(R.id.progress_team)
        recyclerView = view.findViewById(R.id.recycler_team)
        spinner = view.findViewById(R.id.spinner)

        //spinner component
        spinnerItems = resources.getStringArray(R.array.league)
        spinnerAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item, spinnerItems
        )
    }

    private fun initializePresenter() {
        val request = Request()
        val gson = Gson()
        leaguePresenter = LeaguePresenter(this, request, gson)
    }

    private fun setRecycler() {
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        adapter = LeagueAdapter(this.context!!, items)
        recyclerView.adapter = adapter
    }

    private fun setSpinner() {
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val query = spinner.selectedItem.toString()
                leaguePresenter.getLeagueList(query)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

    }

    override fun setLoading() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun setInItData(dataLeague: List<LeagueResults>) {
        items.clear()
        items.addAll(dataLeague)
        adapter.notifyDataSetChanged()
    }

    override fun unSetLoading() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }


}
