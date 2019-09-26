package com.example.lenovo.ubook.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.lenovo.ubook.Apis.Client
import com.example.lenovo.ubook.Models.Modelresponse
import com.example.lenovo.ubook.R
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        responseApi()
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun responseApi() {

        var apikey : String = "58095a5543614da72770c8b350cb7936"

        Client.instance.getcover(apikey)
            .enqueue(object : Callback<Modelresponse> {

                override fun onFailure(call: Call<Modelresponse>?, t: Throwable?) {
                    Toast.makeText(applicationContext, t?.message, Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<Modelresponse>?, response: Response<Modelresponse>?) {
                    val json = response?.body()
                    val gson = Gson().toJson(json)
                    val gsonBuilder = GsonBuilder().create()
                    val homeFeed = gsonBuilder.fromJson(gson, Modelresponse::class.java)

                    runOnUiThread{
                        recyclerView.adapter = MainAdapter(homeFeed)
                    }
                }
            })
    }
}

