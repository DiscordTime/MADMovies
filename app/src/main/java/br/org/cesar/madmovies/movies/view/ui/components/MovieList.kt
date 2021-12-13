package br.org.cesar.madmovies.movies.view.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.NavController
import br.org.cesar.madmovies.movies.domain.model.Movie

@Composable
fun MovieList(movies: State<List<Movie>>, lazystate: LazyListState,
              navController: NavController, update: (() -> Unit)) {
    MovieListContent(movies, lazystate, update, navController)
}

@Composable
fun MovieListContent(
    movies: State<List<Movie>>,
    lazystate: LazyListState,
    update: (() -> Unit),
    navController: NavController
) {
    LazyColumn(state = lazystate) {
        items(movies.value) { movie ->
            MovieItem(movie = movie, navController)
        }
    }
    if (lazystate.isScrolledToTheEnd()) {
       update()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieItem(movie: Movie, navController: NavController) {
    Card(
        onClick = {
            navController.navigate("movieDetails/"+movie.id)
    }) {
        Text(text = movie.title)
    }
}

fun LazyListState.isScrolledToTheEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1