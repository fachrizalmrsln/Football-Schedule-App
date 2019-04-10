package com.id.zul.submission4kade.adapter.team

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.id.zul.submission4kade.R
import com.id.zul.submission4kade.database.FavoriteTeam
import com.squareup.picasso.Picasso

class FavoriteTeamAdapter(private val context: Context, private val favorite: List<FavoriteTeam>) :
    RecyclerView.Adapter<FavoriteTeamAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): FavoriteTeamAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.recycler_favorite_team_template, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return favorite.size
    }

    override fun onBindViewHolder(holder: FavoriteTeamAdapter.ViewHolder, position: Int) {
        holder.bindItem(favorite[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageViewTeam = itemView.findViewById<ImageView>(R.id.image_favorite_team_template)
        private val textViewTeamName = itemView.findViewById<TextView>(R.id.text_name_favorite_team_template)

        fun bindItem(items: FavoriteTeam) {
            items.let {
                Picasso
                    .get()
                    .load(items.teamLogo)
                    .into(imageViewTeam)
            }
            textViewTeamName.text = items.teamName
        }

    }

}