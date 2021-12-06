package br.org.cesar.madmovies.movies.domain.model

import android.os.Parcelable
import br.org.cesar.madmovies.movies.data.model.RemoteMovie
import br.org.cesar.madmovies.movies.data.model.RemoteMovieList
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(val id: Int, val title: String, val year: String) : Parcelable {
    constructor(movie: RemoteMovie) : this(
        movie.id, movie.title, movie.release_date ?: ""
    )
}