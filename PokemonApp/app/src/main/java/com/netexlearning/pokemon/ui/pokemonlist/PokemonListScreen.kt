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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.netexlearning.pokemon.Pokemon
import coil.compose.AsyncImage

@Composable
fun PokemonListScreen(pokemonList: List<Pokemon>, navController: NavController, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        items(pokemonList) { pokemon ->
            PokemonItem(pokemon = pokemon, navController = navController)
        }
    }
}

@Composable
fun PokemonItem(pokemon: Pokemon, navController: NavController) {
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
                    navController.navigate("pokemonDetail/${pokemon.name}")
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