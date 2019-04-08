package com.id.zul.submission2kade.fragment.team

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.id.zul.submission2kade.R

class FragmentFavoriteTeam : Fragment() {

    fun getFragmentFavoriteTeam(): FragmentFavoriteTeam {
        return FragmentFavoriteTeam()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        val view = inflater
            .inflate(R.layout.fragment_favorite_team, container, false)

        return view
    }

}