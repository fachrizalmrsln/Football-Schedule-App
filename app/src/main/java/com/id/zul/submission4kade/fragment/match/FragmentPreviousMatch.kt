package com.id.zul.submission4kade.fragment.match

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Spinner
import com.google.gson.Gson
import com.id.zul.submission4kade.R
import com.id.zul.submission4kade.adapter.match.PreviousMatchAdapter
import com.id.zul.submission4kade.api.Request
import com.id.zul.submission4kade.model.match.PreviousResults
import com.id.zul.submission4kade.presenter.match.PreviousMatchPresenter
import com.id.zul.submission4kade.view.match.PreviousMatchView

class FragmentPreviousMatch : Fragment(), PreviousMatchView {

    private var items: MutableList<PreviousResults> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var spinner: Spinner
    private lateinit var spinnerItems: Array<String>
    private lateinit var spinnerAdapter: ArrayAdapter<String>
    private lateinit var progressBar: ProgressBar
    private lateinit var previousMatchAdapter: PreviousMatchAdapter
    private lateinit var previousMatchPresenter: PreviousMatchPresenter
    private lateinit var idEvent: String
    private lateinit var idLeague: String

    fun getFragmentPreviousMatch(): FragmentPreviousMatch {
        return FragmentPreviousMatch()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        val view = inflater
            .inflate(R.layout.fragment_previous_match, container, false)

        signInViews(view)
        initializePresenter()
        setRecycler()
        setSpinner()

        return view

    }

    private fun signInViews(view: View) {
        progressBar = view.findViewById(R.id.progress_previous_match)
        recyclerView = view.findViewById(R.id.recycler_previous_match)
        spinner = view.findViewById(R.id.spinner_previous_match)

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
        previousMatchPresenter = PreviousMatchPresenter(this, request, gson)
    }

    private fun setRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        previousMatchAdapter = PreviousMatchAdapter(this.context!!, items)
        recyclerView.adapter = previousMatchAdapter
    }

    private fun setSpinner() {
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                idEvent = spinner.selectedItem.toString()
                idLeague = when (idEvent) {
                    "English Premier League" -> "4328"
                    "English League Championship" -> "4329"
                    "German Bundesliga" -> "4331"
                    "Italian Serie A" -> "4332"
                    "French Ligue 1" -> "4334"
                    "Spanish La Liga" -> "4335"
                    else -> "4328"
                }
                previousMatchPresenter.getPreviousMatch(idLeague)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

    }

    override fun setLoading() {
        progressBar.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }

    override fun setInItData(dataMatch: List<PreviousResults>) {
        items.clear()
        items.addAll(dataMatch)
        previousMatchAdapter.notifyDataSetChanged()
    }

    override fun unSetLoading() {
        progressBar.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }


}