package com.id.zul.submission5kade.fragment.team

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.SearchView
import android.view.*
import android.widget.EditText
import com.id.zul.submission5kade.R
import com.id.zul.submission5kade.activity.SearchTeamActivity

class FragmentTeamsContainer : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewerPager: ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        val view = inflater
            .inflate(R.layout.fragment_team_container, container, false)

        singInViews(view)
        setHasOptionsMenu(true)
        setPager()

        return view
    }

    private fun singInViews(view: View) {
        tabLayout = view.findViewById(R.id.tab_layout_team_container)
        viewerPager = view.findViewById(R.id.viewer_fragment_team_container)
    }

    private fun setPager() {
        viewerPager.adapter = TabFragmentTeam(childFragmentManager)
        tabLayout.setupWithViewPager(viewerPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_search, menu)

        val searchView = menu?.findItem(R.id.searchMenu)?.actionView as SearchView?

        searchView?.queryHint = "search ..."

        searchView?.findViewById<EditText>(android.support.v7.appcompat.R.id.search_src_text)
            ?.setHintTextColor(Color.WHITE)

        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                val intent = Intent(context, SearchTeamActivity::class.java)
                intent.putExtra("query", query)
                startActivity(intent)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })

    }

}