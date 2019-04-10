package com.id.zul.submission4kade.fragment.league

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.id.zul.submission4kade.R
import com.id.zul.submission4kade.adapter.league.LeagueAdapter

class FragmentLeagueContainer : Fragment() {

    private var items: MutableList<String> = mutableListOf()
    private lateinit var adapter: LeagueAdapter
    private lateinit var league: Array<String>
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        val view = inflater
            .inflate(R.layout.fragment_league_container, container, false)

        setList()
        setRecycler(view)

        return view
    }

    private fun setRecycler(view: View) {
        recyclerView = view.findViewById(R.id.recycler_all_league)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    private fun setList() {
        adapter = LeagueAdapter(context!!, items)
        league = resources.getStringArray(R.array.league)
        items.clear()
        items.addAll(league)
        adapter.notifyDataSetChanged()
    }


}