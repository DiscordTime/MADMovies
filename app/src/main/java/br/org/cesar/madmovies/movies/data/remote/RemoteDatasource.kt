package br.org.cesar.madmovies.movies.data.remote

import android.content.Context
import android.net.ConnectivityManager
import br.org.cesar.madmovies.movies.data.IReadDataSource
import br.org.cesar.madmovies.movies.data.model.asMovie
import br.org.cesar.madmovies.movies.domain.model.Movie

class RemoteDatasource(private val context: Context) : IReadDataSource {

    private val retrofitService: MovieDbService = RetrofitServiceFactory.getRetrofitService()

    override suspend fun getMovieList(page: Int): List<Movie> {
        return retrofitService
            .getPopularMovies(RetrofitServiceFactory.API_KEY, page)
            .results.map { it.asMovie() }
    }

    override suspend fun getMovieDetails(movieId: Int): Movie {
        return retrofitService
            .getMovieDetail(movieId, RetrofitServiceFactory.API_KEY)
            .asMovie()
    }

    override suspend fun canRead(): Boolean {
        val cm: ConnectivityManager = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCap = cm.getNetworkCapabilities(cm.activeNetwork)
        return networkCap?.let { true } ?: false
    }
}
