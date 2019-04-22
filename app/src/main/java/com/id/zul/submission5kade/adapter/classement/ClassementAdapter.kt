package com.id.zul.submission5kade.adapter.classement

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.id.zul.submission5kade.R
import com.id.zul.submission5kade.model.classement.ClassementResults

class ClassementAdapter(private val results: List<ClassementResults>) :
    RecyclerView.Adapter<ClassementAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_classement_template, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(results[position])
    }

    override fun getItemCount(): Int = results.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewName = itemView.findViewById<TextView>(R.id.text_team_name_classement_template)
        private val textViewTotal = itemView.findViewById<TextView>(R.id.text_total_classement_template)
        private val textViewWin = itemView.findViewById<TextView>(R.id.text_win_classement_template)
        private val textViewDraw = itemView.findViewById<TextView>(R.id.text_draw_classement_template)
        private var textViewLose = itemView.findViewById<TextView>(R.id.text_lose_classement_template)
        private var textViewPlay = itemView.findViewById<TextView>(R.id.text_play_classement_template)

        fun bindItem(results: ClassementResults) {
            textViewName.text = results.name
            textViewTotal.text = results.total.toString()
            textViewWin.text = results.win.toString()
            textViewDraw.text = results.draw.toString()
            textViewLose.text = results.loss.toString()
            textViewPlay.text = results.played.toString()
        }

    }

}