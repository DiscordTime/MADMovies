package br.org.cesar.madmovies.movies.view

import android.os.Bundle
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

class MoviesActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private val viewModel by viewModels<ListMoviesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MovieActivity()
        }
    }

    @Composable
    private fun MovieActivity() {
        val state = viewModel.movieListFlow
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .collectAsState(initial = viewModel.movieListFlow.value)
        val lazystate = rememberLazyListState()
        MADMoviesTheme {
            navController = rememberNavController()
            NavHost(navController = navController,
                startDestination = "movieList") {
                composable("movieList") {
                    MovieList(state, lazystate, navController) {
                        viewModel.getNextPage()
                    }
                }
                composable(
                    "movieDetails/{movie}",
                    arguments = listOf(navArgument("movie") { type = NavType.StringType})
                ) {
                    MovieDetails(it.arguments?.getString("movie"))
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