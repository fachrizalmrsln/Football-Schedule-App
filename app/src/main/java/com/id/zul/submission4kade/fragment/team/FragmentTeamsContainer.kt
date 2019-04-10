package com.id.zul.submission4kade.fragment.team

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.id.zul.submission4kade.R

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

}