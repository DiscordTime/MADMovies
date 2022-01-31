package br.org.cesar.madmovies.movies.domain.usecase

import br.org.cesar.madmovies.movies.data.IMovieRepository
import br.org.cesar.madmovies.movies.domain.model.Movie

class GetMovieDetail(private val repository: IMovieRepository) {
    suspend operator fun invoke(movieId: Int): Movie {
        return repository.getMovieDetails(movieId)
    }
}