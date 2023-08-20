package com.diegorivera.ejercicio.data.retrofit


import pe.ec3.jurado.dota.data.response.LugarListResponse
import retrofit2.http.GET

interface LugarService {
    @GET("db513fd8-fb5e-4838-ac79-0dfdb0255456")
    suspend fun getLugares() : LugarListResponse

}