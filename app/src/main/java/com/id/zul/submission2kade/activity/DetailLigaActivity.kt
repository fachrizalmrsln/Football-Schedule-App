package com.id.zul.submission2kade.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.id.zul.submission2kade.R
import kotlinx.android.synthetic.main.activity_detail_liga.*

class DetailLigaActivity : AppCompatActivity() {

    private lateinit var name: String
    private lateinit var desc: String
    private var image: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_liga)

        name = intent.getStringExtra("name")
        desc = intent.getStringExtra("description")
        image = intent.getIntExtra("image", 0)

        initToolbar()

        text_title_detail.text = name
        text_description_detail.text = desc
        image_detail.setImageResource(image)

    }

    private fun initToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = name

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
    }

}
