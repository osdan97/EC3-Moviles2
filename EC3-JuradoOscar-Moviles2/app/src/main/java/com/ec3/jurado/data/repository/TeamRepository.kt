package com.ec3.jurado.data.repository

import com.ec3.jurado.data.response.TeamResponse
import com.ec3.jurado.data.retrofit.ServiceInstance
import com.ec3.jurado.model.Team

class TeamRepository {

    suspend fun getTeams():TeamResponse<List<Team>> {
        return try {
            val response = ServiceInstance.getTeamService().getTeams()
            TeamResponse.Success(response)
        } catch (e: Exception) {
            TeamResponse.Error(e)
        }
    }
}