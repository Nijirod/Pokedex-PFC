package com.netexlearning.pokemon.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netexlearning.pokemon.data.local.entities.PokemonDetailEntity
import com.netexlearning.pokemon.data.local.entities.PokemonListEntity
import com.netexlearning.pokemon.data.mapper.PokemonMapper
import com.netexlearning.pokemon.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _pokemonList = MutableStateFlow<List<PokemonListEntity>>(emptyList())
    val pokemonList: StateFlow<List<PokemonListEntity>> get() = _pokemonList

    private val _selectedPokemon = MutableStateFlow<PokemonDetailEntity?>(null)
    val selectedPokemon: StateFlow<PokemonDetailEntity?> get() = _selectedPokemon

    fun loadPokemon(limit: Int, offset: Int) {
        viewModelScope.launch {
            val pokemonList = repository.getPokemonList(limit, offset)
            if (pokemonList.isNotEmpty()) {
                _pokemonList.value = pokemonList
            } else {
                println("No Pokémon data found.")
            }
        }
    }

    fun addPokemon(pokemon: PokemonDetailEntity) {
        viewModelScope.launch {
            repository.insertPokemonDetail(pokemon)
            loadPokemon(limit = 10, offset = 0)
        }
    }

    fun selectPokemon(id: Int) {
        viewModelScope.launch {
            _selectedPokemon.value = repository.getPokemonDetailFromDao(id)
        }
    }

    fun selectPokemonByName(name: String) {
        viewModelScope.launch {
            val pokemonListEntity = repository.getPokemonByName(name)
            _selectedPokemon.value = pokemonListEntity?.let { PokemonMapper.fromListEntityToDetailEntity(it) }
        }
    }

    fun updateFavouriteStatus(id: Int, isFavourite: Boolean) {
        viewModelScope.launch {
            repository.updateFavouriteStatus(id, isFavourite)
        }
    }
}