package br.org.cesar.madmovies.movies.data

import br.org.cesar.madmovies.movies.data.model.RemoteMovieList
import br.org.cesar.madmovies.movies.domain.model.Movie
import br.org.cesar.madmovies.movies.domain.usecase.GetMovieList

interface Repository {

    suspend fun getMovieList(): List<Movie>
    fun getMovieDetails()
}