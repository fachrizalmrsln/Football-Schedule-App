package com.id.zul.submission3kade.fragment.match

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.id.zul.submission3kade.R
import com.id.zul.submission3kade.adapter.match.FavoriteMatchAdapter
import com.id.zul.submission3kade.database.FavoriteMatch
import com.id.zul.submission3kade.presenter.match.FavoriteMatchPresenter
import com.id.zul.submission3kade.view.match.FavoriteMatchView
import kotlinx.android.synthetic.main.fragment_favorite_match.*

class FragmentFavoriteMatch : Fragment(), FavoriteMatchView {

    private var items: MutableList<FavoriteMatch> = mutableListOf()
    private lateinit var favoriteMatchAdapter: FavoriteMatchAdapter
    private lateinit var favoriteMatchPresenter: FavoriteMatchPresenter

    fun getFragmentFavoriteMatch(): FragmentFavoriteMatch {
        return FragmentFavoriteMatch()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        val view = inflater
            .inflate(R.layout.fragment_favorite_match, container, false)

        favoriteMatchAdapter = FavoriteMatchAdapter(this.context!!, items)

        initializePresenter()

        return view
    }

    override fun setIsEmpty() {
        view_empty_favorite_match.visibility = View.VISIBLE
        recycler_favorite_match.visibility = View.GONE
    }

    override fun setInsertData(favoriteMatch: List<FavoriteMatch>) {
        items.clear()
        items.addAll(favoriteMatch)
        favoriteMatchAdapter.notifyDataSetChanged()
        setRecycler()
    }

    override fun unSetIsEmpty() {
        view_empty_favorite_match.visibility = View.GONE
        recycler_favorite_match.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        favoriteMatchPresenter.getData()
    }

    private fun initializePresenter() {
        favoriteMatchPresenter = FavoriteMatchPresenter(this, context!!)
    }

    private fun setRecycler() {
        recycler_favorite_match.layoutManager = LinearLayoutManager(activity)
        recycler_favorite_match.adapter = favoriteMatchAdapter
    }

}