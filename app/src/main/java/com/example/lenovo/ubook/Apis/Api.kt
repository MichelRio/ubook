package com.example.lenovo.ubook.Apis

import com.example.lenovo.ubook.Models.Modelresponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


////    @GET("movie/popular?api_key=58095a5543614da72770c8b350cb7936")

interface Movies{
    @GET("movie/top_rated")
    fun getcover(
        @Query("api_key") apikey: String
    ): Call<Modelresponse>

}