package br.org.cesar.madmovies.movies.view.ui.components

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MovieDetails(movie: String?) {
    Card {
       Text(text = movie ?: "")
    }
}