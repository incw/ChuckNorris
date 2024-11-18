package dev.smolyakoff.chucknorris.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.smolyakoff.chucknorris.features.fact.presentation.FactView
import dev.smolyakoff.chucknorris.features.fact.presentation.FactViewModel
import dev.smolyakoff.chucknorris.features.history.presentation.HistoryView
import dev.smolyakoff.chucknorris.features.history.presentation.HistoryViewModel
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel


@Serializable
data object FactScreenDestination

@Serializable
data object HistoryScreenDestination

@Composable
fun NorrisNavHost(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        modifier = modifier.fillMaxSize(),
        navController = navController,
        startDestination = FactScreenDestination,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it / 6 }
            ) + fadeIn()
        },
        exitTransition = { fadeOut() },
        popEnterTransition = {
            fadeIn()
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it / 6 }
            ) + fadeOut()
        }
    ) {

        composable<FactScreenDestination> {

            val viewModel: FactViewModel = koinViewModel()

            FactView(
                viewModel = viewModel,
                onNewFactClicked = viewModel::reFetch,
                onHistoryFactsClicked = { navController.navigate(HistoryScreenDestination) }
            )
        }


        composable<HistoryScreenDestination> {

            val viewModel: HistoryViewModel = koinViewModel()

            HistoryView(viewModel = viewModel) {
                navController.popBackStack()
            }
        }

    }

}