package com.ec3.jurado.view.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ec3.jurado.data.repository.TeamRepository
import com.ec3.jurado.data.response.TeamResponse
import com.ec3.jurado.model.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteUIteamsViewModel :ViewModel() {
    val repository = TeamRepository()
    val teamsList: MutableLiveData<List<Team>> = MutableLiveData<List<Team>>()

    fun getTeamsFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getTeams()
            when (response) {
                is TeamResponse.Success -> {
                    val allHeroes = response.data.toList()
                    val selectedHeroes = allHeroes.shuffled().take(2)
                    teamsList.postValue(selectedHeroes)
                }
                is TeamResponse.Error -> {

                }
            }
        }
    }
}