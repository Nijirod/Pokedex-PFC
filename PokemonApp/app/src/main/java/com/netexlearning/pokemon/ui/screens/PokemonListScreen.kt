package com.netexlearning.pokemon.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import kotlinx.coroutines.flow.filter
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
    var selectedPokemon by remember { mutableStateOf(pokemonList.firstOrNull()) }
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            selectedPokemon?.let { pokemon ->
                PokemonImageItem(
                    pokemon = pokemon,
                    onItemClick = { pokemonNavigation.navigateToDetail(pokemon.id.toInt()) }
                )
            }
        }
        PokemonListContent(
            pokemonList = pokemonList,
            modifier = Modifier.weight(0.6f),
            onItemClick = { pokemon ->
                selectedPokemon = pokemon
                pokemonNavigation.navigateToDetail(pokemon.id.toInt())
            },
            onLoadMore = { viewModel.loadNextPage() },
            viewModel = viewModel,
            onPokemonSelected = { selectedPokemon = it },
            selectedPokemon = selectedPokemon
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PokemonListContent(
    pokemonList: List<PokemonList>,
    modifier: Modifier,
    onItemClick: (PokemonList) -> Unit,
    onLoadMore: () -> Unit = {},
    viewModel: PokemonListViewModel,
    onPokemonSelected: (PokemonList) -> Unit,
    selectedPokemon: PokemonList?
) {
    val listState = rememberLazyListState()

    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo }
            .collect { visibleItems ->
                if (visibleItems.isNotEmpty() && pokemonList.isNotEmpty()) {
                    val center = listState.layoutInfo.viewportEndOffset / 2
                    val centerItem = visibleItems.minByOrNull {
                        kotlin.math.abs((it.offset + it.size / 2) - center)
                    }
                    centerItem?.let {
                        val centerIndex = it.index.coerceIn(0, pokemonList.size - 1)
                        if (pokemonList[centerIndex] != selectedPokemon) {
                            onPokemonSelected(pokemonList[centerIndex])
                        }
                    }
                }
            }
    }
    LaunchedEffect(pokemonList) {
        if (selectedPokemon !in pokemonList) {
            pokemonList.firstOrNull()?.let { onPokemonSelected(it) }
        }
    }
    LazyColumn(
        state = listState,
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        itemsIndexed(pokemonList) { index, pokemon ->
            val isSelected = pokemon == selectedPokemon
            PokemonListItem(
                pokemon = pokemon,
                isFavorite = pokemon.isFavorite,
                onFavoriteClick = { isFavorite ->
                    viewModel.updateFavoriteStatus(pokemon, isFavorite)
                },
                onItemClick = {
                    onPokemonSelected(pokemon)
                    onItemClick(pokemon)
                },
                isSelected = isSelected
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