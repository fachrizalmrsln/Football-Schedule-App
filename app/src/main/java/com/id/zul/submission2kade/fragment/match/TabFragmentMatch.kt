package com.id.zul.submission2kade.fragment.match

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TabFragmentMatch(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? = when (position) {
        0 -> FragmentNextMatch().getFragmentNextMatch()
        1 -> FragmentPreviousMatch().getFragmentPreviousMatch()
        else -> null
    }

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> "Next Match"
        1 -> "Previous Match"
        else -> ""
    }

    override fun getCount(): Int {
        return 2
    }

}