package com.netexlearning.pokemon.ui.pokemondetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.netexlearning.pokemon.PokemonDetail
import com.netexlearning.pokemon.samplePokemonDetail
import androidx.compose.ui.res.painterResource
import com.netexlearning.pokemon.pokemonList
import com.netexlearning.pokemon.ui.pokemonlist.PokemonListScreen

@Composable
fun PokemonDetailScreen(pokemonDetail: PokemonDetail, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(text = "ID: ${pokemonDetail.id}", style = MaterialTheme.typography.titleLarge)
        Text(text = "Name: ${pokemonDetail.name}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Order: #${pokemonDetail.order}", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(8.dp))

        pokemonDetail.spritesURLs.firstOrNull()?.let {
            Image(
                painter = painterResource(id = it),
                contentDescription = "Image of ${pokemonDetail.name}",
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Species: ${pokemonDetail.species}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Types: ${pokemonDetail.types.joinToString(", ")}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Abilities: ${pokemonDetail.abilities.joinToString(", ")}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Stats: ${pokemonDetail.stats.joinToString(", ")}", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Text(text = "Weight: ${pokemonDetail.weight}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Height: ${pokemonDetail.height}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailPreview() {
    PokemonDetailScreen(pokemonDetail = samplePokemonDetail)
}
@Preview(showBackground = true)
@Composable
fun PokemonListPreview() {
    PokemonListScreen(list = pokemonList)
}
