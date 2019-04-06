package com.id.zul.submission2kade.adapter.league

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.model.league.LeagueResults
import com.squareup.picasso.Picasso

class LeagueAdapter(private var context: Context, private val results: List<LeagueResults>) :
    RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context

        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_template, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(results[position])
    }

    override fun getItemCount(): Int {
        return results.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewLeague: TextView = itemView.findViewById(R.id.text_template)
        private val imageViewLeague: ImageView = itemView.findViewById(R.id.image_template)

        fun bindItem(teams: LeagueResults) {
            textViewLeague.text = teams.nameTeam
            Picasso.get().load(teams.teamIcon).into(imageViewLeague)
        }

    }
}
