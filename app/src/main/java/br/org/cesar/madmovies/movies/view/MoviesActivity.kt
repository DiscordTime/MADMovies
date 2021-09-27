package br.org.cesar.madmovies.movies.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.org.cesar.madmovies.movies.model.Movie
import br.org.cesar.madmovies.movies.view.ui.components.movieDetails
import br.org.cesar.madmovies.movies.view.ui.components.movieList
import br.org.cesar.madmovies.movies.view.ui.theme.MADMoviesTheme

class MoviesActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           movieActivity()
        }
    }

    @Composable
    private fun movieActivity() {
        MADMoviesTheme {
            navController = rememberNavController()
            NavHost(navController = navController,
                startDestination = "movieList") {
                composable("movieList") {
                    movieList(listOf(
                        Movie("Filme 1"),
                        Movie("Filme 2"),
                        Movie("Filme 3")
                    ), navController)}
                composable(
                    "movieDetails/{movie}",
                    arguments = listOf(navArgument("movie") { type = NavType.StringType})
                ) {
                    movieDetails(it.arguments?.getString("movie"))
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        movieActivity()
    }


}