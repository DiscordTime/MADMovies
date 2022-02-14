package br.org.cesar.madmovies.movies.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.org.cesar.madmovies.movies.view.ui.components.MovieDetails
import br.org.cesar.madmovies.movies.view.ui.components.MovieList
import br.org.cesar.madmovies.movies.view.ui.theme.MADMoviesTheme
import br.org.cesar.madmovies.movies.viewmodel.ListMoviesViewModel
import br.org.cesar.madmovies.movies.viewmodel.MovieDetailsViewModel

class MoviesActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private val listViewModel by viewModels<ListMoviesViewModel>()
    private val detailsViewModel by viewModels<MovieDetailsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieActivity()
        }
    }

    @Composable
    private fun MovieActivity() {
        MADMoviesTheme {
            navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "movieList"
            ) {
                composable("movieList") {
                    val state = listViewModel.movieListFlow
                        .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                        .collectAsState(initial = listViewModel.movieListFlow.value)
                    val lazystate = rememberLazyListState()
                    MovieList(state, lazystate, navController) {
                        listViewModel.getNextPage()
                    }
                }
                composable(
                    "movieDetails/{movie}",
                    arguments = listOf(navArgument("movie") { type = NavType.IntType })
                ) {
                    detailsViewModel.movieId = it.arguments?.getInt("movie") ?: -1
                    val state = detailsViewModel.movieFlow
                        .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                        .collectAsState(initial = detailsViewModel.movieFlow.value)
                    MovieDetails(state)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MovieActivity()
    }

}