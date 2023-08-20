package pe.ec3.jurado.dota.data.repository

import com.diegorivera.ejercicio.data.retrofit.ServiceInstance
import pe.ec3.jurado.dota.data.response.ApiResponse
import pe.ec3.jurado.dota.model.Heroe


class HeroesRepository {
    suspend fun getHeroes(): ApiResponse<List<Heroe>> {
        return try {
            val response = ServiceInstance.getHeroeService().getHeroes()
            ApiResponse.Success(response)
        } catch (e: Exception) {
            ApiResponse.Error(e)
        }
    }
}