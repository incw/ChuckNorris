package dev.smolyakoff.chucknorris.features.history.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.smolyakoff.chucknorris.android.R
import dev.smolyakoff.chucknorris.core.presentation.views.EmptyView
import dev.smolyakoff.chucknorris.core.presentation.views.LoadingView

@Composable
fun HistoryView(
    modifier: Modifier = Modifier,
    viewModel: HistoryViewModel,
    onBackClick: () -> Unit
) {

    val viewState = viewModel.viewState.collectAsStateWithLifecycle()

    HistoryView(
        modifier = modifier,
        viewState = viewState,
        onBackClick = onBackClick
    )

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchHistory()
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HistoryView(
    modifier: Modifier = Modifier,
    viewState: State<HistoryViewState>,
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.history_facts),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = stringResource(id = R.string.press_back)
                        )
                    }
                },
                colors = TopAppBarDefaults
                    .centerAlignedTopAppBarColors(
                        titleContentColor = MaterialTheme.colorScheme.secondary,
                        navigationIconContentColor = MaterialTheme.colorScheme.primary,
                        containerColor = MaterialTheme.colorScheme.background
                    )
            )
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (val state = viewState.value) {

                HistoryViewState.Empty -> EmptyView()

                HistoryViewState.Loading -> LoadingView()

                is HistoryViewState.Success -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        items(
                            items = state.items,
                            key = { item -> item.id }
                        ) {
                            ListItem(
                                modifier = Modifier.animateItem(),
                                headlineContent = {
                                    Text(
                                        text = it.fact,
                                        color = MaterialTheme.colorScheme.secondary,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
