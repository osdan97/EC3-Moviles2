package pe.ec3.jurado.dota.view.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.ec3.jurado.dota.data.repository.HeroesRepository
import pe.ec3.jurado.dota.data.response.ApiResponse
import pe.ec3.jurado.dota.model.Heroe

class ListViewModel : ViewModel() {
    val repository = HeroesRepository()
    val heroesList: MutableLiveData<List<Heroe>?> = MutableLiveData()

    fun getHeroesFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getHeroes()
            when (response) {
                is ApiResponse.Error -> {
                    // Manejar el error si es necesario
                    // Por ejemplo, puedes mostrar un mensaje de error en la interfaz de usuario
                }
                is ApiResponse.Success -> {
                    heroesList.postValue(response.data)
                }
            }
        }
    }
}