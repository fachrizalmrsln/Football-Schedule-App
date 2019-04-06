package com.id.zul.submission2kade.fragment.match

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.id.zul.submission2kade.R

class FragmentPreviousMatch : Fragment() {

    fun getFragmentPreviousMatch(): FragmentPreviousMatch {
        return FragmentPreviousMatch()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater
            .inflate(R.layout.fragment_previous_match, container, false)

        return view

    }

}