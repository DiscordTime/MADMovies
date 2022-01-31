package br.org.cesar.madmovies.movies.domain.usecase

import br.org.cesar.madmovies.movies.data.IMovieRepository
import br.org.cesar.madmovies.movies.domain.model.Movie

class GetMovieList(private val repository: IMovieRepository) {
    suspend operator fun invoke(page: Int): List<Movie> {
        return repository.getMovieList(page)
    }
}