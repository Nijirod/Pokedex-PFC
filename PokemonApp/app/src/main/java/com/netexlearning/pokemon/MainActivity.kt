package com.netexlearning.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.netexlearning.pokemon.ui.pokemondetail.PokemonDetailScreen
import com.netexlearning.pokemon.ui.pokemonlist.PokemonListScreen
import com.netexlearning.pokemon.ui.theme.PokemonAppTheme
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    NavHost(navController = navController, startDestination = "pokemonList") {
                        composable("pokemonList") {
                            PokemonListScreen(
                                list = pokemonList,
                                modifier = Modifier.padding(paddingValues)
                            )
                        }
                        composable("pokemonDetail/{pokemonId}") {
                            PokemonDetailScreen(
                                pokemonDetail = samplePokemonDetail,
                                modifier = Modifier.padding(paddingValues)
                            )
                        }
                    }
                }
            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun PokemonListPreview() {
        PokemonAppTheme {
            Scaffold { paddingValues ->
                PokemonListScreen(
                    list = pokemonList,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun PokemonDetailPreview() {
        PokemonAppTheme {
            PokemonDetailScreen(pokemonDetail = samplePokemonDetail)
        }
    }

}

