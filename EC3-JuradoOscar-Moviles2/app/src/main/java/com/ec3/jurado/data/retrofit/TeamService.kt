package com.ec3.jurado.data.retrofit



import com.ec3.jurado.model.Team
import retrofit2.http.GET


interface TeamService {
    @GET("teams")
    suspend fun getTeams(): List<Team>
}
