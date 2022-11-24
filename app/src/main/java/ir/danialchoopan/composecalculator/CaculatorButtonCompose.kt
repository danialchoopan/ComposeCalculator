package ir.danialchoopan.composecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorBtn(
    symbol: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
        .clickable { onClick() }
        .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = symbol,
            fontSize = 34.sp,
            color = Color.White
        )
    }
}