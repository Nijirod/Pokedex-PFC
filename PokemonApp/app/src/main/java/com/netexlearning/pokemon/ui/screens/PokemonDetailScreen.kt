 package com.netexlearning.pokemon.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.netexlearning.pokemon.PokemonDetail
import com.netexlearning.pokemon.R
import com.netexlearning.pokemon.ui.components.StatBar
import com.netexlearning.pokemon.ui.viewmodel.PokemonDetailViewModel
import com.netexlearning.pokemon.utils.ImageResizer

@Composable
fun PokemonDetailScreen(
    pokemonId: Int,
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()
    val pokemonDetail by viewModel.pokemonDetail.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchPokemonDetail(pokemonId)
    }

    pokemonDetail?.let { detail ->
        PokemonDetailContent(
            detail = detail,
            modifier = modifier,
            scrollState = scrollState
        )
    }
}

 @Composable
 private fun PokemonDetailContent(
     detail: PokemonDetail,
     modifier: Modifier,
     scrollState: ScrollState
 ) {
     Column(
         modifier = modifier
             .padding(16.dp)
             .verticalScroll(scrollState)
             .fillMaxWidth(),
         verticalArrangement = Arrangement.spacedBy(8.dp)
     ) {
         Text(
             text = stringResource(R.string.id, detail.id ?: ""),
             style = MaterialTheme.typography.titleLarge
         )
         Text(
             text = stringResource(R.string.name, detail.name ?: ""),
             style = MaterialTheme.typography.titleMedium
         )
         Text(
             text = stringResource(R.string.order, detail.order ?: ""),
             style = MaterialTheme.typography.bodyMedium
         )

         Spacer(modifier = Modifier.height(16.dp))
         AsyncImage(
             model = ImageRequest.Builder(LocalContext.current)
                 .data(detail.spritesURLs?.front_default)
                 .transformations(ImageResizer(200.dp, 200.dp))
                 .build(),
             contentDescription = stringResource(R.string.image_of, detail.name ?: ""),
             modifier = Modifier
                 .padding(8.dp)
                 .size(128.dp)
         )

         Spacer(modifier = Modifier.height(16.dp))
         Text(
             text = stringResource(R.string.species, detail.species?.name ?: ""),
             style = MaterialTheme.typography.bodyMedium
         )
         Text(
             text = stringResource(R.string.types, detail.types?.joinToString(", ") { it.name.toString() } ?: ""),
             style = MaterialTheme.typography.bodyMedium
         )
         Text(
             text = stringResource(
                 R.string.abilities,
                 detail.abilities?.joinToString(", ") { it.name.toString() } ?: ""
             ),
             style = MaterialTheme.typography.bodyMedium
         )

         Spacer(modifier = Modifier.height(16.dp))

         detail.stats?.let { stats ->
             Column(
                 modifier = Modifier
                     .padding(16.dp),
             ) {
                 stats.forEach { stat ->
                     StatBar(
                         statName = stat.name,
                         value = stat.value?.toFloat() ?: 0f ,
                         maxValue = 255f,
                     )
                 }
             }
         }

         Spacer(modifier = Modifier.height(16.dp))

         Row {
             Text(
                 text = stringResource(R.string.weight, detail.weight ?: ""),
                 style = MaterialTheme.typography.bodyMedium
             )
             Spacer(modifier = Modifier.width(16.dp))
             Text(
                 text = stringResource(R.string.height, detail.height ?: ""),
                 style = MaterialTheme.typography.bodyMedium
             )
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