package com.netexlearning.pokemon.ui.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.netexlearning.pokemon.ui.pokemondetail.PokemonDetailScreen
import com.netexlearning.pokemon.ui.pokemonlist.PokemonListScreen
import com.netexlearning.pokemon.ui.pokemonsearch.SearchScreen
import com.netexlearning.pokemon.ui.pokemonsettings.SettingsScreen

@Composable
fun BottomBar(navController: NavHostController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStackEntry?.destination
    val items = listOf(
        ScreenRoutes.PokemonListScreen,
        ScreenRoutes.SearchScreen,
        ScreenRoutes.SettingsScreen
    )

    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.route == screen.route,
                onClick = { navController.navigate(screen.route) },
                icon = {}
            )
        }
    }
}

@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.PokemonListScreen.route,
        modifier = modifier
    ) {
        composable(ScreenRoutes.PokemonListScreen.route) {
            PokemonListScreen(
                pokemonNavigation = PokemonNavigation(navController)
            )
        }
        composable(
            route = "pokemon_detail_screen/{pokemonId}",
            arguments = listOf(navArgument("pokemonId") { type = NavType.IntType })
        ) { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getInt("pokemonId")
            if (pokemonId != null) {
                PokemonDetailScreen(pokemonId = pokemonId)
            } else {
                navController.popBackStack()
            }
        }
        composable(ScreenRoutes.SearchScreen.route) {
            SearchScreen()
        }
        composable(ScreenRoutes.SettingsScreen.route) {
            SettingsScreen()
        }
    }
}