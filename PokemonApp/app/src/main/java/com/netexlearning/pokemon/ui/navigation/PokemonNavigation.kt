package com.netexlearning.pokemon.ui.navigation

import androidx.navigation.NavController

class PokemonNavigation(private val navController: NavController) {
    fun navigateToDetail(pokemonId: String) {
        navController.navigate("pokemonDetail/$pokemonId")
    }
    fun navigateToList() {
        navController.navigate("pokemonList")
    }
}