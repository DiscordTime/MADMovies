package br.org.cesar.madmovies.movies.data.remote

import android.util.Log
import br.org.cesar.madmovies.movies.data.Repository
import br.org.cesar.madmovies.movies.data.model.RemoteMovie
import br.org.cesar.madmovies.movies.data.model.RemoteMovieList
import br.org.cesar.madmovies.movies.domain.model.Movie

object RemoteRepository : Repository {

    private val retrofitService: MovieDbService = RetrofitServiceFactory.getRetrofitService()

    override suspend fun getMovieList(page: Int) : List<Movie> {
        return retrofitService
            .getPopularMovies(RetrofitServiceFactory.api_key, page)
            .results.map { Movie(it) }
    }

    override suspend fun getMovieDetails(movieId: Int): Movie {
        return retrofitService
            .getMovieDetail(movieId, RetrofitServiceFactory.api_key)
            .let { Movie(it) }
    }
}