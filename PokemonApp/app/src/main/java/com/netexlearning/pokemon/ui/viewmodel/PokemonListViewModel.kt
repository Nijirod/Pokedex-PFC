package com.netexlearning.pokemon.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netexlearning.pokemon.Pokemon
import com.netexlearning.pokemon.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val repository: PokemonRepository) : ViewModel() {

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(listOf())
    val pokemonList: StateFlow<List<Pokemon>> get() = _pokemonList

    private var offset = 0
    private val limit = 10
    private var isFetching = false

    init {
        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            if (isFetching) return@launch
            isFetching = true
            try {
                val newPokemon = repository.getPokemonList(limit, offset).mapNotNull { it as? Pokemon }
                println("New Pokemon Fetched: $newPokemon")
                _pokemonList.value = _pokemonList.value + newPokemon
                offset += limit
            } catch (e: Exception) {
                println("Error fetching Pokémon: ${e.message}")
            }
            isFetching = false
        }
    }
    fun updateFavoriteStatus(pokemon: Pokemon, isFavorite: Boolean) {
        viewModelScope.launch {
            repository.updateFavouriteStatus(pokemon.id.toInt(), isFavorite)
            _pokemonList.value = _pokemonList.value.map {
                if (it.id == pokemon.id) it.copy(isFavorite = isFavorite) else it
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