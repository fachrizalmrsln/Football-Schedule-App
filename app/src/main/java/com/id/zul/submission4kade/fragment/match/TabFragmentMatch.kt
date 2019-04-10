package com.id.zul.submission4kade.fragment.match

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabFragmentMatch(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? = when (position) {
        0 -> FragmentPreviousMatch().getFragmentPreviousMatch()
        1 -> FragmentNextMatch().getFragmentNextMatch()
        2 -> FragmentFavoriteMatch().getFragmentFavoriteMatch()
        else -> null
    }

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> "Previous Match"
        1 -> "Next Match"
        2 -> "Favorite Match"
        else -> ""
    }

    override fun getCount(): Int {
        return 3
    }

}