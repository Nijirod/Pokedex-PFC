package com.netexlearning.pokemon.ui.pokemonlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.netexlearning.pokemon.Pokemon
import coil.compose.AsyncImage
import com.netexlearning.pokemon.ui.navigation.PokemonNavigation

@Composable
fun PokemonListScreen(pokemonList: List<Pokemon>, pokemonNavigation: PokemonNavigation, modifier: Modifier = Modifier) {
    PokemonListScreen(pokemonList, modifier, onItemClick = { pokemonNavigation.navigateToDetail(it.id) })
}

@Composable
private fun PokemonListScreen(pokemonList: List<Pokemon>, modifier: Modifier, onItemClick: (Pokemon) -> Unit){
    LazyColumn(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        items(pokemonList) { pokemon ->
            PokemonItem(pokemon = pokemon, onItemClick = onItemClick)
        }
    }
}

@Composable
fun PokemonItem(pokemon: Pokemon, onItemClick: (Pokemon) -> Unit) {
    var isFavorite by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Name: ${pokemon.name}")
        AsyncImage(
            model = pokemon.urlImage,
            contentDescription = "Image of ${pokemon.name}",
            modifier = Modifier
                .padding(8.dp)
                .size(128.dp)
                .clickable {
                    onItemClick(pokemon)
                },
            contentScale = ContentScale.Crop
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = "URL: ")
            Text(text = pokemon.url ?: "No URL")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = { isFavorite = !isFavorite }) {
                val icon = if (isFavorite) Icons.Filled.Star else Icons.Outlined.Star
                val iconColor = if (isFavorite) Color.Yellow else Color.Gray
                Icon(imageVector = icon, contentDescription = "Favorite", tint = iconColor)
            }
        }
    }
}

@Composable
@Preview
fun PokemonListScreenPreview() {
    val samplePokemonList = listOf(
        Pokemon("Pikachu", "https://pokeapi.co/api/v2/pokemon/25/"),
        Pokemon("Charmander", "https://pokeapi.co/api/v2/pokemon/4/"),
        Pokemon("Bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/")
    )
    PokemonListScreen(pokemonList = samplePokemonList, pokemonNavigation = PokemonNavigation(rememberNavController()), modifier = Modifier.fillMaxSize())
}