package com.id.zul.submission2kade.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.model.DataModel
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer

class DataAdapter(
    private val items: MutableList<DataModel>,
    private var context: Context,
    private var listener: (DataModel) -> Unit
) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.recycler_template, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        private val textViewEvent = containerView.findViewById<TextView>(R.id.text_template)!!
        private val imageResource = containerView.findViewById<ImageView>(R.id.image_template)!!
        private val cardView = containerView.findViewById<CardView>(R.id.card_template)!!

        fun bindItem(items: DataModel, listener: (DataModel) -> Unit) {

            textViewEvent.text = items.eventName

            items.imageResource.let {
                Picasso
                    .get()
                    .load(it!!)
                    .into(imageResource)
            }

            cardView.setOnClickListener {
                listener(items)
            }

        }

    }
}