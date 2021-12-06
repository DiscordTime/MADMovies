package br.org.cesar.madmovies.movies.domain.usecase

import br.org.cesar.madmovies.movies.data.Repository
import br.org.cesar.madmovies.movies.domain.model.Movie

object GetMovieList {
    suspend operator fun invoke(repository: Repository, page: Int): List<Movie> {
        return repository.getMovieList(page)
    }
}