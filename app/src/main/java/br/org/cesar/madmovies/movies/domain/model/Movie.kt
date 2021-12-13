package br.org.cesar.madmovies.movies.domain.model

import br.org.cesar.madmovies.movies.data.model.RemoteMovie

data class Movie(val id: Int,
                 val title: String,
                 val year: String,
                 val overview: String,
                 val popularity: Double) {
    constructor(): this(-1, "", "", "", 0.0)
    constructor(movie: RemoteMovie) : this(
        movie.id, movie.title, movie.release_date ?: "",
        movie.overview, movie.popularity
    )
}