package br.org.cesar.madmovies.movies.view.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.navigation.NavController
import br.org.cesar.madmovies.movies.domain.model.Movie

@Composable
fun MovieList(movies: State<List<Movie>>, navController: NavController) {
    MovieListContent(movies, navController)
}

@Composable
fun MovieListContent(
    movies: State<List<Movie>>,
    navController: NavController) {
    LazyColumn() {
        items(movies.value) { movie ->
            MovieItem(movie = movie, navController)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieItem(movie: Movie, navController: NavController) {
    Card(
        onClick = {
            navController.navigate("movieDetails/"+movie.title)
    }) {
        Text(text = movie.title)
    }
}