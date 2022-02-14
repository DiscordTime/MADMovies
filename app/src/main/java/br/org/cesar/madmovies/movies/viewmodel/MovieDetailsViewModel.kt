package br.org.cesar.madmovies.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.org.cesar.madmovies.movies.data.MovieRepository
import br.org.cesar.madmovies.movies.data.remote.RemoteDatasource
import br.org.cesar.madmovies.movies.domain.model.Movie
import br.org.cesar.madmovies.movies.domain.usecase.GetMovieDetail
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MovieDetailsViewModel(application: Application) : AndroidViewModel(application) {

    var movieId: Int = -1
    private var _movieFlow: MutableStateFlow<Movie> = MutableStateFlow(Movie())
    var movieFlow: StateFlow<Movie> =
        _movieFlow
            .onSubscription {
                if (_movieFlow.value.id != movieId) {
                    getMovieDetail(movieId)
                }
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), _movieFlow.value)

    private val getMovieDetailUseCase = GetMovieDetail(
        MovieRepository(
            listOf(RemoteDatasource(application.applicationContext)),
            listOf()
        )
    )

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch {
            _movieFlow.emit(getMovieDetailUseCase(movieId))
        }
    }

}
