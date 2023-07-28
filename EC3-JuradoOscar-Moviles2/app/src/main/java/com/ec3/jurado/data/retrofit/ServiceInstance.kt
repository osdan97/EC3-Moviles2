package com.ec3.jurado.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceInstance {
    private  val retrofit = Retrofit.Builder().baseUrl("https://api.opendota.com/api/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getTeamService():TeamService = retrofit.create(TeamService::class.java)
}