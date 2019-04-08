package com.id.zul.submission2kade.fragment.team

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
import com.id.zul.submission2kade.adapter.team.TeamsAdapter
import com.id.zul.submission2kade.api.Request
import com.id.zul.submission2kade.model.team.TeamResults
import com.id.zul.submission2kade.presenter.team.TeamsPresenter
import com.id.zul.submission2kade.view.team.TeamsView

class FragmentAllTeam : Fragment(), TeamsView {

    private var items: MutableList<TeamResults> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TeamsAdapter
    private lateinit var teamsPresenter: TeamsPresenter
    private lateinit var spinner: Spinner
    private lateinit var spinnerItems: Array<String>
    private lateinit var spinnerAdapter: ArrayAdapter<String>
    private lateinit var progressBar: ProgressBar

    fun getFragmentAllTeam(): FragmentAllTeam {
        return FragmentAllTeam()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        val view = inflater
            .inflate(R.layout.fragment_all_team, container, false)

        signInViews(view)
        initializePresenter()
        setRecycler()
        setSpinner()

        return view
    }

    private fun signInViews(view: View) {
        progressBar = view.findViewById(R.id.progress_all_team)
        recyclerView = view.findViewById(R.id.recycler_all_team)
        spinner = view.findViewById(R.id.spinner_all_team)

        //spinner component
        spinnerItems = resources.getStringArray(R.array.league)
        spinnerAdapter = ArrayAdapter(
            requireContext(),
            R.layout.spinner_item,
            R.id.text_spinner_item,
            spinnerItems
        )
    }

    private fun initializePresenter() {
        val request = Request()
        val gson = Gson()
        teamsPresenter = TeamsPresenter(this, request, gson)
    }

    private fun setRecycler() {
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        adapter = TeamsAdapter(this.context!!, items)
        recyclerView.adapter = adapter
    }

    private fun setSpinner() {
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val query = spinner.selectedItem.toString()
                teamsPresenter.getLeagueList(query)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

    }

    override fun setLoading() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun setInItData(dataTeam: List<TeamResults>) {
        items.clear()
        items.addAll(dataTeam)
        adapter.notifyDataSetChanged()
    }

    override fun unSetLoading() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

}
