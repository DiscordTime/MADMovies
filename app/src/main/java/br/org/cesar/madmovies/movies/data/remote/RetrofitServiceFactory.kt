package br.org.cesar.madmovies.movies.data.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.IllegalArgumentException

class RetrofitServiceFactory {

    companion object {
        val url = "https://api.themoviedb.org/3/";
        val api_key = "932ade838ca63f016cd03c3c36943018"; // Remember to add api_key before running
        fun getRetrofitService(): MovieDbService {
            if (api_key.isEmpty()) throw IllegalArgumentException("Empty api key")
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
            return retrofit.create(MovieDbService::class.java)
        }
    }
}