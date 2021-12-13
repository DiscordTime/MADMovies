package br.org.cesar.madmovies.movies.data.remote

import br.org.cesar.madmovies.movies.data.Repository
import br.org.cesar.madmovies.movies.data.model.asMovie
import br.org.cesar.madmovies.movies.domain.model.Movie

object RemoteRepository : Repository {

    private val retrofitService: MovieDbService = RetrofitServiceFactory.getRetrofitService()

    override suspend fun getMovieList(page: Int) : List<Movie> {
        return retrofitService
            .getPopularMovies(RetrofitServiceFactory.API_KEY, page)
            .results.map { it.asMovie() }
    }

    override suspend fun getMovieDetails(movieId: Int): Movie {
        return retrofitService
            .getMovieDetail(movieId, RetrofitServiceFactory.API_KEY)
            .asMovie()
    }
}
