package com.id.zul.submission4kade.fragment.team

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.id.zul.submission4kade.R
import com.id.zul.submission4kade.adapter.team.FavoriteTeamAdapter
import com.id.zul.submission4kade.database.FavoriteTeam
import com.id.zul.submission4kade.presenter.team.FavoriteTeamPresenter
import com.id.zul.submission4kade.view.team.FavoriteTeamView
import kotlinx.android.synthetic.main.fragment_favorite_team.*

class FragmentFavoriteTeam : Fragment(), FavoriteTeamView {

    private var items: MutableList<FavoriteTeam> = mutableListOf()
    private lateinit var favoriteTeamAdapter: FavoriteTeamAdapter
    private lateinit var favoriteTeamPresenter: FavoriteTeamPresenter

    fun getFragmentFavoriteTeam(): FragmentFavoriteTeam {
        return FragmentFavoriteTeam()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        val view = inflater
            .inflate(R.layout.fragment_favorite_team, container, false)

        favoriteTeamAdapter = FavoriteTeamAdapter(this.context!!, items)

        initializePresenter()

        return view
    }

    override fun setIsEmpty() {
        view_empty_favorite_team.visibility = View.VISIBLE
        recycler_favorite_team.visibility = View.GONE
    }

    override fun setInsertData(favoriteTeam: List<FavoriteTeam>) {
        items.clear()
        items.addAll(favoriteTeam)
        favoriteTeamAdapter.notifyDataSetChanged()
        setRecycler()
    }

    override fun unSetIsEmpty() {
        view_empty_favorite_team.visibility = View.GONE
        recycler_favorite_team.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        favoriteTeamPresenter.getData()
    }

    private fun initializePresenter() {
        favoriteTeamPresenter = FavoriteTeamPresenter(this, context!!)
    }

    private fun setRecycler() {
        recycler_favorite_team.layoutManager = GridLayoutManager(activity, 2)
        recycler_favorite_team.adapter = favoriteTeamAdapter
    }


}