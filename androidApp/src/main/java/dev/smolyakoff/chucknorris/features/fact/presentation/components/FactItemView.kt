package dev.smolyakoff.chucknorris.features.fact.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.smolyakoff.chucknorris.features.fact.domain.model.FactModel

@Composable
fun FactItemView(
    modifier: Modifier = Modifier,
    model: FactModel
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = model.fact,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}


@Preview
@Composable
fun FactItemViewPreview(modifier: Modifier = Modifier) {
    FactItemView(modifier, FactModel("Some fact some fact some fact"))
}