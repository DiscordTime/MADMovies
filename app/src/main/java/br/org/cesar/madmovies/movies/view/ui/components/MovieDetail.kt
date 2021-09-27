package br.org.cesar.madmovies.movies.view.ui.components

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import br.org.cesar.madmovies.movies.model.Movie

@Composable
fun movieDetails(movie: String?) {
    Card {
       Text(text = movie ?: "")
    }
}