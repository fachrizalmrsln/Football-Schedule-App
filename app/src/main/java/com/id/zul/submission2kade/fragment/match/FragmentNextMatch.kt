package com.id.zul.submission2kade.fragment.match

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.id.zul.submission2kade.R

class FragmentNextMatch : Fragment() {

    fun getFragmentNextMatch(): FragmentNextMatch {
        return FragmentNextMatch()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater
            .inflate(R.layout.fragment_next_match, container, false)

        return view

    }

}