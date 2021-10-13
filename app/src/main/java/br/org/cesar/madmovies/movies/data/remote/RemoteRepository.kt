package br.org.cesar.madmovies.movies.data.remote

import android.util.Log
import br.org.cesar.madmovies.movies.data.Repository
import br.org.cesar.madmovies.movies.data.model.RemoteMovie
import br.org.cesar.madmovies.movies.data.model.RemoteMovieList
import br.org.cesar.madmovies.movies.domain.model.Movie

object RemoteRepository : Repository {

    private val retrofitService: MovieDbService = RetrofitServiceFactory.getRetrofitService()

    override suspend fun getMovieList() : List<Movie> {
        return retrofitService
            .getPopularMovies(RetrofitServiceFactory.api_key)
            .results.map { Movie(it) }
    }

    override fun getMovieDetails() {
        TODO("Not yet implemented")
    }
}