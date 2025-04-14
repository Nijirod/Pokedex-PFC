package com.netexlearning.pokemon.ui.screens

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.netexlearning.pokemon.Pokemon
import coil.compose.AsyncImage
import com.netexlearning.pokemon.ui.components.PokemonItem
import com.netexlearning.pokemon.ui.navigation.PokemonNavigation
import com.netexlearning.pokemon.ui.viewmodel.PokemonListViewModel
import timber.log.Timber

@Composable
fun PokemonListScreen(
    pokemonNavigation: PokemonNavigation,
    modifier: Modifier = Modifier
) {
    val viewModel: PokemonListViewModel = hiltViewModel()
    val pokemonList by viewModel.pokemonList.collectAsState()

    PokemonListContent(
        pokemonList = pokemonList,
        modifier = modifier,
        onItemClick = { pokemonNavigation.navigateToDetail(it.id.toInt()) },
        onLoadMore = { viewModel.loadNextPage() },
        viewModel = viewModel
    )
}

@Composable
private fun PokemonListContent(
    pokemonList: List<Pokemon>,
    modifier: Modifier,
    onItemClick: (Pokemon) -> Unit,
    onLoadMore: () -> Unit = {},
    viewModel: PokemonListViewModel
) {
    LazyColumn(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        items(pokemonList) { pokemon ->
            PokemonItem(
                pokemon = pokemon,
                isFavorite = pokemon.isFavorite,
                onItemClick = onItemClick,
                onFavoriteClick = { isFavorite ->
                    viewModel.updateFavoriteStatus(pokemon, isFavorite)
                }
            )
        }
        item {
            LaunchedEffect(Unit) {
                onLoadMore()
            }
        }
    }
}

@Composable
@Preview
fun PokemonListScreenPreview() {
    PokemonListScreen(
        pokemonNavigation = PokemonNavigation(rememberNavController()),
        modifier = Modifier.fillMaxSize()
    )
}