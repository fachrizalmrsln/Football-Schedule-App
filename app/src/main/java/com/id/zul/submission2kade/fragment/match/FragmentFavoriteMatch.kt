package com.id.zul.submission2kade.fragment.match

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.id.zul.submission2kade.R

class FragmentFavoriteMatch : Fragment() {

    fun getFragmentFavoriteMatch(): FragmentFavoriteMatch {
        return FragmentFavoriteMatch()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        val view = inflater
            .inflate(R.layout.fragment_favorite_match, container, false)

        return view
    }

}