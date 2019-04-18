package com.id.zul.submission5kade.fragment.team

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabFragmentTeam(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? = when (position) {
        0 -> FragmentAllTeam().getFragmentAllTeam()
        1 -> FragmentFavoriteTeam().getFragmentFavoriteTeam()
        else -> null
    }

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> "All Team"
        1 -> "Favorite Team"
        else -> ""
    }

    override fun getCount(): Int {
        return 2
    }

}