package com.id.zul.submission2kade.fragment.match

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabFragmentMatch(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? = when (position) {
        0 -> FragmentPreviousMatch().getFragmentPreviousMatch()
        1 -> FragmentNextMatch().getFragmentNextMatch()
        else -> null
    }

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> "Previous Match"
        1 -> "Next Match"
        else -> ""
    }

    override fun getCount(): Int {
        return 2
    }

}