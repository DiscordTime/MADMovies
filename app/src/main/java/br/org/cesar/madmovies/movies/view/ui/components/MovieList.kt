package br.org.cesar.madmovies.movies.view.ui.components

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.core.os.bundleOf
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.Navigator
import androidx.navigation.navArgument
import br.org.cesar.madmovies.movies.model.Movie
import br.org.cesar.madmovies.movies.view.MoviesActivity

@Composable
fun movieList(movies: List<Movie>, navController: NavController) {
    LazyColumn() {
        items(movies) { movie ->
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