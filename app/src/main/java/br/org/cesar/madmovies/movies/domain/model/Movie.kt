package br.org.cesar.madmovies.movies.domain.model

data class Movie(val id: Int,
                 val title: String,
                 val year: String,
                 val overview: String,
                 val popularity: Double
                 ) {
    constructor(): this(-1, "", "", "", 0.0)
}