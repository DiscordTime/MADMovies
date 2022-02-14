package br.org.cesar.madmovies.movies.data

import br.org.cesar.madmovies.movies.domain.model.Movie

class MovieRepository(
    private val readDataSources: List<IReadDataSource>,
    private val writeDataSources: List<IWriteDataSource>
) : IMovieRepository {

    override suspend fun getMovieList(page: Int): List<Movie> {
        val mapOfMovie: MutableMap<Int, Movie> = mutableMapOf()
        readDataSources
            .filter { ds -> ds.canRead() }
            .map { ds -> ds.getMovieList(page) }
            .flatMap { list -> list.asIterable() }
            .forEach { movieInList ->
                mapOfMovie[movieInList.id]?.let { movieInMap ->
                    if (movieInMap.lastUpdatedTime <= movieInList.lastUpdatedTime) {
                        mapOfMovie.replace(movieInList.id, movieInList)
                    }
                } ?: run {
                    mapOfMovie[movieInList.id] = movieInList
                }
            }

        return mapOfMovie.values.toList()
    }

    override suspend fun getMovieDetails(movieId: Int): Movie {
        var movie: Movie? = null
        readDataSources
            .map { ds -> ds.getMovieDetails(movieId) }
            .forEach {
                if (movie?.lastUpdatedTime ?: 0 <= it.lastUpdatedTime) {
                    movie = it
                }
            }
        return movie ?: Movie()
    }
}