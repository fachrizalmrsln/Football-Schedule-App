package com.id.zul.submission2kade.adapter.match

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.activity.DetailMatchActivity
import com.id.zul.submission2kade.model.match.MatchResults
import org.jetbrains.anko.startActivity

class NextMatchAdapter(private val context: Context, private val results: List<MatchResults>) :
    RecyclerView.Adapter<NextMatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchAdapter.ViewHolder {
        return NextMatchAdapter.ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_match_template, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(results[position])
        holder.itemView.setOnClickListener {
            val item = results[position]
            context.startActivity<DetailMatchActivity>(
                "match" to item.eventId,
                "homeTeam" to item.idHomeTeam,
                "awayTeam" to item.idAwayTeam
            )
        }
    }

    override fun getItemCount(): Int = results.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewDate = itemView.findViewById<TextView>(R.id.text_date_template)
        private val textViewTeam1 = itemView.findViewById<TextView>(R.id.text_team1_template)
        private val textViewTeam2 = itemView.findViewById<TextView>(R.id.text_team2_template)

        fun bindItem(results: MatchResults) {
            textViewTeam1.text = results.strHomeTeam
            textViewTeam2.text = results.strAwayTeam
//            textViewDate.text = results.dateEvent.let { DateHelper.formatDateToMatch(it) }
        }

    }

}