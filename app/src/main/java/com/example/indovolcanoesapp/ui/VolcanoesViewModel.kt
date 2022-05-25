package com.example.indovolcanoesapp.ui


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.indovolcanoesapp.network.Volcanoes
import com.example.indovolcanoesapp.network.VolcanoesApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class VolcanoesApiStatus { LOADING, ERROR, DONE }

class VolcanoesViewModel : ViewModel() {

    private var _status = MutableLiveData<VolcanoesApiStatus>()
    val status = _status
    private var _volcanoesList = MutableLiveData<List<Volcanoes>>()
    val volcanoesList = _volcanoesList
    private var _selectedVolcanoes = MutableLiveData<Volcanoes>()
    val selectedVolcanoes = _selectedVolcanoes

    init {
        getVolcanoesList()
    }
    private fun getVolcanoesList(){
        viewModelScope.launch {
            _status.value = VolcanoesApiStatus.LOADING
            try {
                _volcanoesList.value = VolcanoesApi.retrofitService.getVolcanoes()
                _status.value = VolcanoesApiStatus.DONE
            }
            catch (e : Exception) {
                _status.value = VolcanoesApiStatus.ERROR
                _volcanoesList.value = listOf()
            }
        }
    }

    fun onVolcanoesClicked(volcanoes: Volcanoes){
        _selectedVolcanoes.value = volcanoes
    }
}