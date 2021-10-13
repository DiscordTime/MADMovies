package br.org.cesar.madmovies.movies.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.org.cesar.madmovies.movies.data.remote.RemoteRepository
import br.org.cesar.madmovies.movies.domain.model.Movie
import br.org.cesar.madmovies.movies.domain.usecase.GetMovieList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListMoviesViewModel : ViewModel() {

    private var _movieListFlow: MutableStateFlow<List<Movie>> = MutableStateFlow(mutableListOf())
    var movieListFlow: StateFlow<List<Movie>> =
        _movieListFlow

    init {
        updateMovieList()
    }

    fun updateMovieList() {
        viewModelScope.launch {
            _movieListFlow.emit(GetMovieList(RemoteRepository))
        }
    }

}