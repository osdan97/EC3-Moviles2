package com.ec3.jurado.view.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ec3.jurado.data.repository.TeamRepository
import com.ec3.jurado.data.response.TeamResponse
import com.ec3.jurado.model.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListUIteamsViewModel:ViewModel() {

    val repository = TeamRepository()
    val teamsList: MutableLiveData<List<Team>?> = MutableLiveData()

    fun getTeamsFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getTeams()
            when (response) {
                is TeamResponse.Error -> {
                }
                is TeamResponse.Success -> {
                    teamsList.postValue(response.data)
                }
            }
        }
    }
}