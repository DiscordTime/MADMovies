package br.org.cesar.madmovies.movies.view.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import br.org.cesar.madmovies.movies.domain.model.Movie



@Composable
fun MovieDetails(state: State<Movie>) {
    Card {
        Column {
            Text(text = "Title: ${state.value.title}")
            Text(text = "Year: ${state.value.year}")
            Text(text = "Overview: ${state.value.overview}")
            Text(text = "Popularity: ${state.value.popularity}")
        }
    }
}