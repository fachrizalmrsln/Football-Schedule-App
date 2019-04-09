package com.id.zul.submission3kade.adapter.league

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.id.zul.submission3kade.R
import com.id.zul.submission3kade.activity.DetailLeagueActivity
import org.jetbrains.anko.startActivity

class LeagueAdapter(private var context: Context, private val results: MutableList<String>) :
    RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context

        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_league_template, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(results[position])
        holder.itemView.setOnClickListener {
            context.startActivity<DetailLeagueActivity>(
                "leagueName" to results[position]
            )
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewLeagueName: TextView = itemView.findViewById(R.id.text_league_template)

        fun bindItem(leagues: String) {
            textViewLeagueName.text = leagues
        }

    }
}
