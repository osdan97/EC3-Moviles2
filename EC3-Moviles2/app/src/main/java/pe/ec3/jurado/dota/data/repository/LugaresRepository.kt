package pe.ec3.jurado.dota.data.repository


import com.diegorivera.ejercicio.data.retrofit.ServiceInstance
import pe.ec3.jurado.dota.data.response.ApiResponse
import pe.ec3.jurado.dota.data.response.LugarListResponse


class LugaresRepository {
    suspend fun getLugares(): ApiResponse<LugarListResponse>

    {
        return try{
            val response = ServiceInstance.getLugarService().getLugares()
            ApiResponse.Success(response)
        }catch(e:Exception){
            ApiResponse.Error(e)
        }

    }
}