package pe.ec3.jurado.dota.view.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.ec3.jurado.dota.data.repository.HeroesRepository
import pe.ec3.jurado.dota.data.response.ApiResponse
import pe.ec3.jurado.dota.model.Heroe

class FavoriteListViewModel : ViewModel() {

    val repository = HeroesRepository()
    val heroesList: MutableLiveData<List<Heroe>> = MutableLiveData<List<Heroe>>()

    fun getHeroesFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getHeroes()
            when (response) {
                is ApiResponse.Success -> {
                    val allHeroes = response.data.toList()
                    val selectedHeroes = allHeroes.shuffled().take(2) // Selecciona 1 héroes aleatorios
                    heroesList.postValue(selectedHeroes)
                }
                is ApiResponse.Error -> {

                }
            }
        }
    }}