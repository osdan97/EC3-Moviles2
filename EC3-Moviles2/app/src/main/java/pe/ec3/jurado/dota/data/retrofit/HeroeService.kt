package pe.ec3.jurado.dota.data.retrofit

import pe.ec3.jurado.dota.model.Heroe
import retrofit2.http.GET

interface HeroeService {
    @GET("heroStats")
    suspend fun getHeroes(): List<Heroe>
}