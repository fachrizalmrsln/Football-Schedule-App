package com.id.zul.submission2kade.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.id.zul.submission2kade.R
import com.id.zul.submission2kade.activity.DetailLigaActivity
import com.id.zul.submission2kade.adapter.DataAdapter
import com.id.zul.submission2kade.model.DataModel
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.toast

class FragmentTeam : Fragment() {

    private lateinit var list: ArrayList<DataModel>
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater
            .inflate(R.layout.fragment_team, container, false)

        recyclerView = view.findViewById(R.id.recycler_team)

        inItData()
        setRecycler()

        return view
    }

    private fun inItData() {

        list = arrayListOf()

        val name = resources.getStringArray(R.array.data_name)
        val image = resources.obtainTypedArray(R.array.data_image)
        val description = resources.getStringArray(R.array.data_description)

        list.clear()

        for (i in name.indices) {
            list.add(
                DataModel(
                    name[i],
                    image.getResourceId(i, 0),
                    description[i]
                )
            )
        }

        image.recycle()

    }

    private fun setRecycler() {

        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = DataAdapter(list, context!!) {
            toast("${it.eventName} clicked !")
            startActivity(
                intentFor<DetailLigaActivity>(
                    "name" to it.eventName,
                    "description" to it.description,
                    "image" to it.imageResource
                )
            )
        }
    }


}