
package com.netexlearning.pokemon.ui.pokemondetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.netexlearning.pokemon.ui.viewmodel.PokemonDetailViewModel

@Composable
fun PokemonDetailScreen(
    pokemonId: Int,
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    val pokemonDetail by viewModel.pokemonDetail.collectAsState()

    LaunchedEffect(pokemonId) {
        viewModel.fetchPokemonDetail(pokemonId)
    }

    pokemonDetail?.let { detail ->
        Column(
            modifier = modifier
                .padding(16.dp)
                .verticalScroll(scrollState)
                .fillMaxWidth()
        ) {
            Text(text = "ID: ${detail.id}", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Name: ${detail.name}", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Order: #${detail.order}", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
                model = detail.spritesURLs?.frontDefault,
                contentDescription = "Image of ${detail.name}",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Species: ${detail.species?.name}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Types: ${detail.types?.joinToString(", ") { it.name }}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Abilities: ${detail.abilities?.joinToString(", ") { it.name }}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))

            Column {
                Text(text = "Stats:", style = MaterialTheme.typography.bodyMedium)
                detail.stats?.forEach { stat ->
                    Text(text = "${stat.name}: ${stat.value}", style = MaterialTheme.typography.bodyMedium)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text(text = "Weight: ${detail.weight}", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Height: ${detail.height}", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailScreenPreview() {
    PokemonDetailScreen(
        pokemonId = 1
    )
}