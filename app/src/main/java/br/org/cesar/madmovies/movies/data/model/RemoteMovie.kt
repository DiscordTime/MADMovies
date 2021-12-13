package br.org.cesar.madmovies.movies.data.model

import br.org.cesar.madmovies.movies.domain.model.Movie
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteMovie(
 val adult: Boolean = false,
 val image: String = "",
 val genre_ids: List<Int> = listOf(),
 val id: Int = 0,
 val original_language: String = "",
 val original_title: String = "",
 val overview: String = "",
 val popularity: Double = 0.0,
 val poster_path: String? = "",
 val release_date: String? = "",
 val title: String = "",
 val vote_average: Double = 0.0,
 val vote_count: Int = 0
)

fun RemoteMovie.asMovie() = Movie(id, title, release_date ?: "", overview, popularity)
