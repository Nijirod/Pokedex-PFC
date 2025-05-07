package com.netexlearning.pokemon.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.netexlearning.pokemon.PokemonList
import com.netexlearning.pokemon.ui.components.PokemonImageItem
import com.netexlearning.pokemon.ui.components.PokemonListItem
import com.netexlearning.pokemon.ui.navigation.PokemonNavigation
import com.netexlearning.pokemon.ui.viewmodel.PokemonListViewModel

@Composable
fun PokemonListScreen(
    pokemonNavigation: PokemonNavigation,
    modifier: Modifier = Modifier
) {
    val viewModel: PokemonListViewModel = hiltViewModel()
    val pokemonList by viewModel.pokemonList.collectAsState()
    Row {
        PokemonImageItem(
            pokemon = PokemonList(
                name = "Pikachu",
                url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png",
                isFavorite = false
            ),
            onItemClick = { pokemonNavigation.navigateToDetail(it.id.toInt()) }
        )
        PokemonListContent(
            pokemonList = pokemonList,
            modifier = modifier,
            onItemClick = { pokemonNavigation.navigateToDetail(it.id.toInt()) },
            onLoadMore = { viewModel.loadNextPage() },
            viewModel = viewModel
        )
    }

}

@Composable
private fun PokemonListContent(
    pokemonList: List<PokemonList>,
    modifier: Modifier,
    onItemClick: (PokemonList) -> Unit,
    onLoadMore: () -> Unit = {},
    viewModel: PokemonListViewModel
) {
    LazyColumn(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        items(pokemonList) { pokemon ->
            PokemonListItem(
                pokemon = pokemon,
                isFavorite = pokemon.isFavorite,
                onFavoriteClick = { isFavorite ->
                    viewModel.updateFavoriteStatus(pokemon, isFavorite)
                },
                onItemClick = {
                    onItemClick(pokemon)
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