package br.org.cesar.madmovies.movies.domain.usecase

import android.util.Log
import br.org.cesar.madmovies.movies.data.Repository
import br.org.cesar.madmovies.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

object GetMovieList {
    suspend operator fun invoke(repository: Repository) : List<Movie> {
        val list = repository.getMovieList()
        Log.d("duds", "GetMovieList $list")
        return list
    }
}