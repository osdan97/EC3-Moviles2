package com.diegorivera.ejercicio.data.retrofit

import pe.ec3.jurado.dota.model.Heroe

import retrofit2.http.GET


interface HeroeService {
    @GET("heroes")
    suspend fun getHeroes(): List<Heroe>
}
