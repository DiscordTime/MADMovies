package br.org.cesar.madmovies.movies.data.remote

import br.org.cesar.madmovies.movies.data.model.RemoteMovie
import br.org.cesar.madmovies.movies.data.model.RemoteMovieList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("page") page: Int
    ): RemoteMovieList
    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int,
                               @Query("api_key") apiKey: String): RemoteMovie
}