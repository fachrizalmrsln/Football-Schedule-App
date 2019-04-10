package com.id.zul.submission4kade.adapter.match

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.id.zul.submission4kade.R
import com.id.zul.submission4kade.database.FavoriteMatch

class FavoriteMatchAdapter(private val context: Context, private val favorite: List<FavoriteMatch>) :
    RecyclerView.Adapter<FavoriteMatchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.recycler_favorite_match_template, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return favorite.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(favorite[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewDate = itemView.findViewById<TextView>(R.id.text_date_favorite_match_template)
        private val textViewTime = itemView.findViewById<TextView>(R.id.text_time_favorite_match_template)
        private val textViewHomeTeam = itemView.findViewById<TextView>(R.id.text_team1_favorite_match_template)
        private val textViewAwayTeam = itemView.findViewById<TextView>(R.id.text_team2_favorite_match_template)
        private val textViewHomeScore = itemView.findViewById<TextView>(R.id.text_score1_favorite_match_template)
        private val textViewAwayScore = itemView.findViewById<TextView>(R.id.text_score2_favorite_match_template)

        fun bindItem(items: FavoriteMatch) {
            textViewDate.text = items.matchDate
            textViewTime.text = items.matchTime
            textViewHomeTeam.text = items.matchHomeTeam
            textViewAwayTeam.text = items.matchAwayTeam
            textViewHomeScore.text = items.matchHomeScore
            textViewAwayScore.text = items.matchAwayScore
        }
    }
}