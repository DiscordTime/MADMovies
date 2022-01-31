package br.org.cesar.madmovies.movies.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val year: String,
    val overview: String,
    val popularity: Double,
    val lastUpdatedTime: Long
) {
    constructor() : this(-1, "", "", "", 0.0, now())
    constructor(
        id: Int,
        title: String,
        year: String,
        overview: String,
        popularity: Double
    ) : this(id, title, year, overview, popularity, now())

    companion object {
        fun now(): Long = System.currentTimeMillis()
    }
}