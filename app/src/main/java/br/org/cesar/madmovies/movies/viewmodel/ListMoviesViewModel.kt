package br.org.cesar.madmovies.movies.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.org.cesar.madmovies.movies.data.remote.RemoteRepository
import br.org.cesar.madmovies.movies.domain.model.Movie
import br.org.cesar.madmovies.movies.domain.usecase.GetMovieList
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ListMoviesViewModel : ViewModel() {

    private var page: Int = 1
    private var _movieListFlow: MutableStateFlow<MutableList<Movie>> = MutableStateFlow(mutableListOf())
    var movieListFlow: StateFlow<List<Movie>> =
        _movieListFlow
            .onSubscription {
                if (_movieListFlow.value.size == 0) {
                    getNextPage()
                }
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), _movieListFlow.value)

    fun getNextPage() {
        Log.d("duds", "getNextPage $page")
        viewModelScope.launch {
            Log.d("duds", "getPage $page")
            val currentList = _movieListFlow.value
            currentList.addAll(GetMovieList(RemoteRepository, page++))
            _movieListFlow.emit(currentList)
        }
    }

}