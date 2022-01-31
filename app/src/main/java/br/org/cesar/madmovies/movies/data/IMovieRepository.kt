package br.org.cesar.madmovies.movies.data

import br.org.cesar.madmovies.movies.domain.model.Movie

interface IMovieRepository {
    suspend fun getMovieList(page: Int): List<Movie>
    suspend fun getMovieDetails(movieId: Int): Movie
}