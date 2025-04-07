package com.netexlearning.pokemon.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netexlearning.pokemon.Pokemon
import com.netexlearning.pokemon.api.PokemonApiServiceInterface
import com.netexlearning.pokemon.data.mapper.PokemonMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val apiService: PokemonApiServiceInterface): ViewModel() {

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(listOf())
    val pokemonList: StateFlow<List<Pokemon>> get() = _pokemonList

    init {
        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            try {
                val response = apiService.getPokemonList()
                _pokemonList.value = PokemonMapper.fromApiResponse(response)
            } catch (e: Exception) {
                _pokemonList.value = listOf()
            }
        }
    }
}