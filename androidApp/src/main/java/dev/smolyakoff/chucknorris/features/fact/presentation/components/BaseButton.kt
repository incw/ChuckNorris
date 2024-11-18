package dev.smolyakoff.chucknorris.features.fact.presentation.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp;

@Composable
fun BaseButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults
            .buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ),
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}