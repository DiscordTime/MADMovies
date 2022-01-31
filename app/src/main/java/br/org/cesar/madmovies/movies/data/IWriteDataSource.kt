package br.org.cesar.madmovies.movies.data

import br.org.cesar.madmovies.movies.domain.model.Movie

interface IWriteDataSource {
    suspend fun createMovie(movie: Movie)
    suspend fun updateMovie(movie: Movie)
    suspend fun canWrite() : Boolean
}