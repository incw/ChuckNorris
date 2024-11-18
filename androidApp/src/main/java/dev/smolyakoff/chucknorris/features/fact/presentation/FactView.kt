package dev.smolyakoff.chucknorris.features.fact.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.smolyakoff.chucknorris.android.R
import dev.smolyakoff.chucknorris.core.presentation.views.ErrorView
import dev.smolyakoff.chucknorris.core.presentation.views.LoadingView
import dev.smolyakoff.chucknorris.features.fact.presentation.components.BaseButton
import dev.smolyakoff.chucknorris.features.fact.presentation.components.FactItemView

@Composable
fun FactView(
    viewModel: FactViewModel,
    onNewFactClicked: () -> Unit,
    onHistoryFactsClicked: () -> Unit
) {

    val viewState = viewModel.viewState.collectAsStateWithLifecycle()

    FactView(
        modifier = Modifier,
        viewState = viewState,
        onNewFactClicked = onNewFactClicked,
        onHistoryFactsClicked = onHistoryFactsClicked
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FactView(
    modifier: Modifier = Modifier,
    viewState: State<FactViewState>,
    onNewFactClicked: () -> Unit,
    onHistoryFactsClicked: () -> Unit
) {

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.facts),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                actions = {
                    IconButton(
                        onClick = onHistoryFactsClicked
                    ) {
                        Icon(
                            imageVector = Icons.Default.Bookmarks,
                            contentDescription = stringResource(id = R.string.history_facts)
                        )
                    }
                },
                colors = TopAppBarDefaults
                    .centerAlignedTopAppBarColors(
                        titleContentColor = MaterialTheme.colorScheme.secondary,
                        actionIconContentColor = MaterialTheme.colorScheme.primary,
                        containerColor = MaterialTheme.colorScheme.background
                    )
            )
        },
        bottomBar = {
            BaseButton(
                onClick = onNewFactClicked,
                text = stringResource(id = R.string.new_fact),
                enabled = viewState.value != FactViewState.Loading,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {

            AnimatedContent(
                modifier = Modifier.fillMaxSize(),
                targetState = viewState.value,
                transitionSpec = {
                    fadeIn(
                        animationSpec = tween(durationMillis = 700)
                    ) togetherWith
                            fadeOut(animationSpec = tween(durationMillis = 700))
                },
                label = ""
            ) { state ->

                when (state) {
                    FactViewState.Error -> ErrorView()
                    FactViewState.Loading -> LoadingView()
                    is FactViewState.Success -> {
                        FactItemView(
                            model = state.fact,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        )
                    }
                }

            }


        }
    }

}


