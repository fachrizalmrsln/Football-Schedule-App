package com.id.zul.submission5kade.fragment.classement

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ProgressBar
import android.widget.Spinner
import com.google.gson.Gson
import com.id.zul.submission5kade.R
import com.id.zul.submission5kade.adapter.classement.ClassementAdapter
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.model.classement.ClassementResults
import com.id.zul.submission5kade.presenter.classement.ClassementPresenter
import com.id.zul.submission5kade.view.classement.ClassementView

class FragmentClassementContainer : Fragment(), ClassementView {

    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView
    private lateinit var spinner: Spinner
    private lateinit var cardView: CardView
    private lateinit var spinnerItems: Array<String>
    private lateinit var spinnerAdapter: ArrayAdapter<String>
    private lateinit var idEvent: String
    private lateinit var idLeague: String
    private lateinit var classementPresenter: ClassementPresenter
    private lateinit var classementAdapter: ClassementAdapter
    private var items: MutableList<ClassementResults> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {
        val view = inflater
            .inflate(R.layout.fragment_classement_container, container, false)

        signInViews(view)
        initializePresenter()
        setSpinner()
        setRecycler()

        return view
    }

    private fun signInViews(view: View) {
        progressBar = view.findViewById(R.id.progress_classement)
        recyclerView = view.findViewById(R.id.recycler_classement)
        spinner = view.findViewById(R.id.spinner_classement)
        cardView = view.findViewById(R.id.card_classement)

        //spinner component
        spinnerItems = resources.getStringArray(R.array.league)
        spinnerAdapter = ArrayAdapter(
            requireContext(),
            R.layout.spinner_item,
            R.id.text_spinner_item,
            spinnerItems
        )
    }

    private fun initializePresenter() {
        val request = Request()
        val gson = Gson()
        classementPresenter = ClassementPresenter(this, request, gson)
    }

    private fun setSpinner() {
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                idEvent = spinner.selectedItem.toString()
                idLeague = when (idEvent) {
                    "English Premier League" -> "4328"
                    "English League Championship" -> "4329"
                    "German Bundesliga" -> "4331"
                    "Italian Serie A" -> "4332"
                    "French Ligue 1" -> "4334"
                    "Spanish La Liga" -> "4335"
                    else -> "4328"
                }
                classementPresenter.getClassement(idLeague)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

    }

    private fun setRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        classementAdapter = ClassementAdapter(this.context!!, items)
        recyclerView.adapter = classementAdapter
    }

    override fun setLoadingClassement() {
        progressBar.visibility = View.VISIBLE
        cardView.visibility = View.GONE

    }

    override fun setInItDataClassement(dataClassement: List<ClassementResults>) {
        items.clear()
        items.addAll(dataClassement)
        classementAdapter.notifyDataSetChanged()
    }

    override fun unSetLoadingClassement() {
        progressBar.visibility = View.GONE
        cardView.visibility = View.VISIBLE

    }


}