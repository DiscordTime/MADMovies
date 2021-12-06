package br.org.cesar.madmovies.movies.data

import br.org.cesar.madmovies.movies.domain.model.Movie

interface Repository {

    suspend fun getMovieList(page: Int): List<Movie>
    fun getMovieDetails()
}