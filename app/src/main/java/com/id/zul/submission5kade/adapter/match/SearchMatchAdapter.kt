package com.id.zul.submission5kade.adapter.match

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.id.zul.submission5kade.R
import com.id.zul.submission5kade.activity.DetailMatchActivity
import com.id.zul.submission5kade.model.match.MatchResults
import com.id.zul.submission5kade.utils.Utils
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*

class SearchMatchAdapter(private val context: Context, private val results: List<MatchResults>) :
    RecyclerView.Adapter<SearchMatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_search_match_template, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(results[position])
        holder.itemView.setOnClickListener {
            val item = results[position]
            context.startActivity<DetailMatchActivity>(
                "matchID" to item.idEvent,
                "homeTeamID" to item.idHomeTeam,
                "awayTeamID" to item.idAwayTeam
            )
        }
    }

    override fun getItemCount(): Int = results.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewDate = itemView.findViewById<TextView>(R.id.text_date_search_template)
        private val textViewTeam1 = itemView.findViewById<TextView>(R.id.text_team1_search_template)
        private val textViewTeam2 = itemView.findViewById<TextView>(R.id.text_team2_search_template)
        private val textViewTime = itemView.findViewById<TextView>(R.id.text_time_search_template)

        private lateinit var getTime: String

        private lateinit var simpleDateFormat: SimpleDateFormat

        @SuppressLint("SetTextI18n")
        fun bindItem(results: MatchResults) {
            textViewTeam1.text = results.strHomeTeam
            textViewTeam2.text = results.strAwayTeam

            textViewDate.text = results.dateEvent?.let { Utils.formatToDate(it) }

            getTime = results.strTime!!
            convertTime()
            textViewTime.text = "$getTime WIB"
        }

        @SuppressLint("SimpleDateFormat")
        private fun convertTime() {
            simpleDateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            val formatTime = SimpleDateFormat(simpleDateFormat.toPattern())
            formatTime.timeZone = TimeZone.getTimeZone("GMT")
            val time = formatTime.parse(getTime)
            val simpleDateFormat = SimpleDateFormat("kk:mm")
            getTime = simpleDateFormat.format(time)
        }

    }

}