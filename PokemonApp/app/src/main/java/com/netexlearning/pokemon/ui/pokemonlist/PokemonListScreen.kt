package com.netexlearning.pokemon.ui.pokemonlist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import coil.compose.AsyncImage
import com.netexlearning.pokemon.Pokemon
import com.netexlearning.pokemon.pokemonList

@Composable
fun PokemonListScreen(list: List<Pokemon>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(list) { pokemon ->
            PokemonItem(pokemon = pokemon)
        }
    }
}
@Composable
fun PokemonItem(pokemon: Pokemon) {
    var isFavorite by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "Name: ${pokemon.name}")
        AsyncImage(
            model = pokemon.urlImage,
            contentDescription = "Image of ${pokemon.name}",
            modifier = Modifier
                .padding(8.dp)
        )

        Text(text = pokemon.urlImage)

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {

            Text(text = "URL: ")
            Text(text = pokemon.url ?: "No URL")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = { isFavorite = !isFavorite }
            ) {
                val icon = if (isFavorite) Icons.Filled.Star else Icons.Outlined.Star
                val iconColor = if (isFavorite) Color.Yellow else Color.Gray
                Icon(imageVector = icon, contentDescription = "Favorite", tint = iconColor)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonListPreview() {
    PokemonListScreen(list = pokemonList)
}
