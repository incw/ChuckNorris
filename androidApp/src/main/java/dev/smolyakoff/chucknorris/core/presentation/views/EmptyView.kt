package dev.smolyakoff.chucknorris.core.presentation.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.smolyakoff.chucknorris.android.R

@Composable
fun EmptyView(
    modifier: Modifier = Modifier,
    text: String = stringResource(id = R.string.empty_history)
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text, fontSize = 18.sp, fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.primary
        )
    }
}