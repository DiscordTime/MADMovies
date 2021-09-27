package br.org.cesar.madmovies.movies.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(val title: String) : Parcelable