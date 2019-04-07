package com.id.zul.submission2kade.adapter.match

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.model.match.MatchResults
import java.text.SimpleDateFormat
import java.util.*

class NextMatchAdapter(private val context: Context, private val results: List<MatchResults>) :
    RecyclerView.Adapter<NextMatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchAdapter.ViewHolder {
        return NextMatchAdapter.ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(com.id.zul.submission2kade.R.layout.recycler_next_match_template, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(results[position])
    }

    override fun getItemCount(): Int = results.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewDate = itemView.findViewById<TextView>(R.id.text_date_template)
        private val textViewTeam1 = itemView.findViewById<TextView>(R.id.text_team1_template)
        private val textViewTeam2 = itemView.findViewById<TextView>(R.id.text_team2_template)
        private val textViewTime = itemView.findViewById<TextView>(R.id.text_time_next_template)

        private lateinit var getDate: String
        private lateinit var getTime: String

        @SuppressLint("SetTextI18n")
        fun bindItem(results: MatchResults) {
            textViewTeam1.text = results.strHomeTeam
            textViewTeam2.text = results.strAwayTeam

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