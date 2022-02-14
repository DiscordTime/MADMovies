package br.org.cesar.madmovies.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.org.cesar.madmovies.movies.data.MovieRepository
import br.org.cesar.madmovies.movies.data.remote.RemoteDatasource
import br.org.cesar.madmovies.movies.domain.model.Movie
import br.org.cesar.madmovies.movies.domain.usecase.GetMovieList
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ListMoviesViewModel(application: Application) : AndroidViewModel(application) {

    private var page: Int = 1
    private val _movieListFlow: MutableStateFlow<MutableList<Movie>> =
        MutableStateFlow(mutableListOf())
    val movieListFlow: StateFlow<List<Movie>> =
        _movieListFlow
            .onSubscription {
                if (_movieListFlow.value.size == 0) {
                    getNextPage()
                }
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), _movieListFlow.value)

    private val getMovieList = GetMovieList(
        MovieRepository(
            listOf(RemoteDatasource(application.applicationContext)),
            listOf()
        )
    )

    fun getNextPage() {
        viewModelScope.launch {
            val currentList = _movieListFlow.value.apply {
                addAll(getMovieList(page++))
            }
            _movieListFlow.emit(currentList)
        }
    }

}