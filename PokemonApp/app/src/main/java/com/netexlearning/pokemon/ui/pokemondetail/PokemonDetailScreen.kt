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
import coil.compose.AsyncImage

@Composable
fun PokemonDetailScreen(pokemonDetail: PokemonDetail, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
            .fillMaxWidth()
    ) {
        Text(text = "ID: ${pokemonDetail.id}", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Name: ${pokemonDetail.name}", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Order: #${pokemonDetail.order}", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            model = samplePokemonDetail.spritesURLs.frontDefault,
            contentDescription = "Image of ${samplePokemonDetail.name}",
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Species: ${pokemonDetail.species.name}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Types: ${pokemonDetail.types.joinToString(", ") { it.name }}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Abilities: ${pokemonDetail.abilities.joinToString(", ") { it.name }}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))

        Column {
            Text(text = "Stats:", style = MaterialTheme.typography.bodyMedium)
            pokemonDetail.stats.forEach { stat ->
                Text(text = "${stat.name}: ${stat.value}", style = MaterialTheme.typography.bodyMedium)
            }
        }

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
fun PokemonDetailScreenPreview() {
    PokemonDetailScreen(
        pokemonDetail = samplePokemonDetail
    )
}
