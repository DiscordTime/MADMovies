package br.org.cesar.madmovies.movies.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteMovieList(
    val page: Int = 1,
    val results: List<RemoteMovie>,
    val totalPages: Int = 1,
    val totalResults: Int = 0
)
