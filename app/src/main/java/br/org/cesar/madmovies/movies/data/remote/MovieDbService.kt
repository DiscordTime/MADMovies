package br.org.cesar.madmovies.movies.data.remote

import br.org.cesar.madmovies.movies.data.model.RemoteMovieList
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String,
                                 @Query("page") page: Int): RemoteMovieList
}