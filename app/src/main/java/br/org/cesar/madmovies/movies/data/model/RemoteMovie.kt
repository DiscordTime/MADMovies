package br.org.cesar.madmovies.movies.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteMovie(
 val adult: Boolean,
 val image: String = "",
 val genre_ids: List<Int>,
 val id: Int,
 val original_language: String,
 val original_title: String,
 val overview: String,
 val popularity: Double,
 val poster_path: String,
 val release_date: String,
 val title: String,
 val vote_average: Double,
 val vote_count: Int
)
