package com.netexlearning.pokemon.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.netexlearning.pokemon.Pokemon
import com.netexlearning.pokemon.api.PokemonApiResponse
import androidx.lifecycle.viewModelScope
import com.netexlearning.pokemon.api.PokemonApiServiceInterface
import com.netexlearning.pokemon.data.mapper.PokemonMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val apiResClient: PokemonApiServiceInterface): ViewModel() {

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(listOf())
    val pokemonList: StateFlow<List<Pokemon>> get() = _pokemonList

    fun readData() {
        _pokemonList.value = com.netexlearning.pokemon.pokemonListMock
        viewModelScope.launch{
            val response =apiResClient.getPokemonList()
            _pokemonList.value = response.map { PokemonMapper.fromApiResponse(it)!! }
        }

    }
}