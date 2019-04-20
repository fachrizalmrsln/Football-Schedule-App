package com.id.zul.submission5kade.adapter.player

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.id.zul.submission5kade.R
import com.id.zul.submission5kade.activity.DetailPlayerActivity
import com.id.zul.submission5kade.model.player.PlayerResults
import com.squareup.picasso.Picasso
import org.jetbrains.anko.startActivity

class PlayersAdapter(private var context: Context, private val results: List<PlayerResults>) :
    RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context

        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_player_template, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(results[position])
        holder.itemView.setOnClickListener {
            context.startActivity<DetailPlayerActivity>(
                "playerID" to results[position].idPlayer
            )
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewPlayerName: TextView = itemView.findViewById(R.id.text_player_template)
        private val textViewPlayerPosition: TextView = itemView.findViewById(R.id.text_player_position_template)
        private val textViewPlayerCountry: TextView = itemView.findViewById(R.id.text_player_country_template)
        private val imageViewPlayer: ImageView = itemView.findViewById(R.id.image_player_template)

        fun bindItem(player: PlayerResults) {
            textViewPlayerName.text = player.strPlayer
            textViewPlayerPosition.text = player.strPosition
            textViewPlayerCountry.text = player.strNationality
            Picasso.get().load(player.strThumb).into(imageViewPlayer)
        }

    }
}
