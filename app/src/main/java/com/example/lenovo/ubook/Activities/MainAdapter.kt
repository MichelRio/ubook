package com.example.lenovo.ubook.Activities

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lenovo.ubook.Models.Modelresponse
import com.example.lenovo.ubook.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recycler.view.*

class MainAdapter(val movies: Modelresponse) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var title : String? = null
    var poster : String?= null
    var overview : String?= null
    var votes : String?= null
    var language : String?= null
    var daterelease : String?= null


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(p0.context)
        val cellForRow = layoutInflater.inflate(R.layout.item_recycler, p0, false)
        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {

        return movies.results.count()
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, position: Int) {
        val inf = movies.results.get(position)
        val customViewHolder = p0 as CustomViewHolder
        val context = p0.view.context


        customViewHolder.view.tvmovies.text = inf.title
        customViewHolder.view.tvvotes.text = inf.vote_average.toString()
        customViewHolder.view.tvdate.text = inf.release_date
        var imgCover = "https://image.tmdb.org/t/p/w185_and_h278_bestv2"+inf.poster_path

        Picasso.get()
            .load(imgCover)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fit()
            .into(customViewHolder.view.ivCover)


        p0.itemView.setOnClickListener { view ->
                title = inf.title
                poster = imgCover
                overview = inf.overview
                votes = inf.vote_average.toString()
                language = inf.original_language
                daterelease = inf.release_date

            loadDetailsActivity(context)
        }

    }

    private fun loadDetailsActivity(context: Context) {

        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("title", title)
        intent.putExtra("poster", poster)
        intent.putExtra("overview", overview)
        intent.putExtra("votes", votes)
        intent.putExtra("language", language)
        intent.putExtra("date", daterelease)
        context.startActivity(intent)

    }



}

class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
}