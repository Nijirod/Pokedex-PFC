package com.netexlearning.pokemon.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netexlearning.pokemon.PokemonList
import com.netexlearning.pokemon.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val repository: PokemonRepository) : ViewModel() {

    private val _pokemonList = MutableStateFlow<List<PokemonList>>(emptyList())
    val pokemonList: StateFlow<List<PokemonList>> get() = _pokemonList

    private var offset = 0
    private val limit = 10
    private var isFetching = false

    private fun fetchPokemonList() {
        viewModelScope.launch {
            if (isFetching) return@launch
            isFetching = true
            try {
                val pokemonFromDb = repository.getAllPokemonList(limit, offset)
                if (pokemonFromDb.size < limit) {
                    repository.fetchAndStorePokemonList(limit, offset)
                }
                val updatedPokemon = repository.getAllPokemonList(limit, offset)
                val newPokemon = updatedPokemon.map { PokemonList(it.name, it.url, it.isFavorite) }
                _pokemonList.value = _pokemonList.value + newPokemon
                offset += limit
            } catch (e: Exception) {
                println("Error obteniendo Pokémon: ${e.message}")
            }
            isFetching = false
        }
    }
    fun updateFavoriteStatus(pokemonList: PokemonList, isFavorite: Boolean) {
        viewModelScope.launch {
            try {
                repository.updatePokemonFavoriteStatus(pokemonList.name, isFavorite)
                val updatedList = _pokemonList.value.map {
                    if (it.name == pokemonList.name) it.copy(isFavorite = isFavorite) else it
                }
                _pokemonList.value = updatedList
            } catch (e: Exception) {
                println("Error actualizando estado de favorito: ${e.message}")
            }
        }
    }


    fun loadNextPage() {
        fetchPokemonList()
    }

    fun resetPage() {
        offset = 0
        _pokemonList.value = listOf()
        fetchPokemonList()
    }
}