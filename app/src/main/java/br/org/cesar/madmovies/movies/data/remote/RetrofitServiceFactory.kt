package br.org.cesar.madmovies.movies.data.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.IllegalArgumentException

class RetrofitServiceFactory {

    companion object {
        private const val URL = "https://api.themoviedb.org/3/";
        const val API_KEY = ""; // Remember to add api_key before running
        fun getRetrofitService(): MovieDbService {
            if (API_KEY.isEmpty()) throw IllegalArgumentException("Empty api key")
            val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            return retrofit.create(MovieDbService::class.java)
        }
    }
}