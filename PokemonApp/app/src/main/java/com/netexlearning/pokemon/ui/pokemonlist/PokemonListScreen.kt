package com.netexlearning.pokemon.ui.pokemonlist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.netexlearning.pokemon.R
import com.netexlearning.pokemon.Pokemon
import com.netexlearning.pokemon.pokemonList

@Composable
fun PokemonListScreen(list: List<Pokemon>) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        list.forEach { pokemon ->
            PokemonItem(pokemon)
        }
    }
}

@Composable
fun PokemonItem(pokemon: Pokemon) {
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = pokemon.imageResourceURL,
            contentDescription = pokemon.name
        )

        Text(text = "ID: ${pokemon.id}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Name: ${pokemon.name}", style = MaterialTheme.typography.titleMedium)
        Text(text = "API URL: ${pokemon.url ?: "No URL available"}", style = MaterialTheme.typography.bodySmall)
    }
}


@Preview(showBackground = true)
@Composable
fun PokemonListPreview() {
    PokemonListScreen(pokemonList)
}

@Preview
@Composable
fun PokemonItemPreview(){
    PokemonItem(pokemonList.first())
}
