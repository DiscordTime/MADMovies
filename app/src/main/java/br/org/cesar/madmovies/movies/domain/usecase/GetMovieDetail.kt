package br.org.cesar.madmovies.movies.domain.usecase

import android.util.Log
import br.org.cesar.madmovies.movies.data.Repository
import br.org.cesar.madmovies.movies.domain.model.Movie

object GetMovieDetail {
    suspend operator fun invoke(repository: Repository, movieId: Int): Movie {
        Log.i("duds", "MovieId = "+movieId)
        return repository.getMovieDetails(movieId)
    }
}