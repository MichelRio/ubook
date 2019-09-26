package com.example.lenovo.ubook.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.lenovo.ubook.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_details.tvdate
import kotlinx.android.synthetic.main.item_recycler.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        var extras = intent.extras
        var title = extras.getString("title")
        var poster = extras.getString("poster")
        var overview = extras.getString("overview")
        var votes = extras.getString("votes")
        var language = extras.getString("language")
        var daterelease = extras.getString("daterelease")

        tvtitle.text = title
        ivposter
        tvoverview.text = overview
        tvvote.text = votes
        tvlanguage.text = language
        tvdate.text = daterelease

        Picasso.get()
            .load(poster)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fit()
            .into(ivposter)

    }
}
