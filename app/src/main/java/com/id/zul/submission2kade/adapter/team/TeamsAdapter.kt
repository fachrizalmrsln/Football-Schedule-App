package com.id.zul.submission2kade.adapter.team

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.activity.DetailTeamActivity
import com.id.zul.submission2kade.model.team.TeamResults
import com.squareup.picasso.Picasso
import org.jetbrains.anko.startActivity

class TeamsAdapter(private var context: Context, private val results: List<TeamResults>) :
    RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context

        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_team_template, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(results[position])
        holder.itemView.setOnClickListener {
            context.startActivity<DetailTeamActivity>(
                "teamID" to results[position].idTeam,
                "teamName" to results[position].nameTeam
            )
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewTeam: TextView = itemView.findViewById(R.id.text_team_template)
        private val imageViewTeam: ImageView = itemView.findViewById(R.id.image_team_template)

        fun bindItem(teams: TeamResults) {
            textViewTeam.text = teams.nameTeam
            Picasso.get().load(teams.logoTeam).into(imageViewTeam)
        }

    }
}
