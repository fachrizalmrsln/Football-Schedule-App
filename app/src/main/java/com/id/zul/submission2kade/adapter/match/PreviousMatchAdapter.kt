package com.id.zul.submission2kade.adapter.match

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.activity.DetailMatchActivity
import com.id.zul.submission2kade.model.match.PreviousResults
import org.jetbrains.anko.startActivity
import java.text.SimpleDateFormat
import java.util.*

class PreviousMatchAdapter(private val context: Context, private val results: List<PreviousResults>) :
    RecyclerView.Adapter<PreviousMatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PreviousMatchAdapter.ViewHolder {
        return PreviousMatchAdapter.ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_previous_match_template, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItem(results[position])
        holder.itemView.setOnClickListener {
            val item = results[position]

            if (item.strHomeTeam!!.isEmpty())
                item.strHomeTeam = "Unknown"
            if (item.strAwayTeam!!.isEmpty())
                item.strAwayTeam = "Unknown"

            if (item.strLeague!!.isEmpty())
                item.strLeague = "Unknown"

            if (item.dateEvent!!.isEmpty())
                item.dateEvent = "Unknown"
            if (item.strTime!!.isEmpty())
                item.strTime = "Unknown"

            if (item.intHomeScore!!.isEmpty())
                item.intHomeScore = "Unknown"
            if (item.intAwayScore!!.isEmpty())
                item.intAwayScore = "Unknown"

            if (item.strHomeGoalDetails == null)
                item.strHomeGoalDetails = "Unknown"
            if (item.strAwayGoalDetails == null)
                item.strAwayGoalDetails = "Unknown"

            if (item.intHomeShots == null)
                item.intHomeShots = "Unknown"
            if (item.intAwayShots == null)
                item.intAwayShots = "Unknown"

            context.startActivity<DetailMatchActivity>(
                "match" to item.idEvent,
                "homeTeam" to item.strHomeTeam,
                "awayTeam" to item.strAwayTeam,
                "league" to item.strLeague,
                "date" to item.dateEvent,
                "time" to item.strTime,
                "goalHome" to item.intHomeScore,
                "goalAway" to item.intAwayScore,
                "soccerHome" to item.strHomeGoalDetails,
                "soccerAway" to item.strAwayGoalDetails,
                "shootHome" to item.intHomeShots,
                "shootAway" to item.intAwayShots
            )
        }
    }

    override fun getItemCount(): Int = results.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewDate = itemView.findViewById<TextView>(R.id.text_date_previous_template)
        private val textViewTeam1 = itemView.findViewById<TextView>(R.id.text_team1_previous_template)
        private val textViewTeam2 = itemView.findViewById<TextView>(R.id.text_team2_previous_template)
        private val textViewScore1 = itemView.findViewById<TextView>(R.id.text_score1_previous_template)
        private val textViewScore2 = itemView.findViewById<TextView>(R.id.text_score2_previous_template)
        private val textViewTime = itemView.findViewById<TextView>(R.id.text_time_previous_template)

        private lateinit var getDate: String
        private lateinit var getTime: String

        @SuppressLint("SetTextI18n")
        fun bindItem(results: PreviousResults) {
            textViewTeam1.text = results.strHomeTeam
            textViewTeam2.text = results.strAwayTeam
            textViewScore1.text = results.intHomeScore
            textViewScore2.text = results.intAwayScore

            getDate = results.dateEvent!!
            convertDate()
            textViewDate.text = getDate

            getTime = results.strTime!!
            convertTime()
            textViewTime.text = "$getTime WIB"
        }

        @SuppressLint("SimpleDateFormat")
        private fun convertDate() {
            val formatDate = SimpleDateFormat("yyyy-MM-dd")
            formatDate.timeZone = TimeZone.getTimeZone("GMT")
            val date = formatDate.parse(getDate)
            val simpleDateFormat = SimpleDateFormat("EEEE, dd MMMM")
            getDate = simpleDateFormat.format(date)
        }

        @SuppressLint("SimpleDateFormat")
        private fun convertTime() {
            val formatTime = SimpleDateFormat("HH:mm:ss")
            formatTime.timeZone = TimeZone.getTimeZone("GMT")
            val time = formatTime.parse(getTime)
            val simpleDateFormat = SimpleDateFormat("kk:mm")
            getTime = simpleDateFormat.format(time)
        }

    }

}