package ir.danialchoopan.composecalculator.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.danialchoopan.composecalculator.domain.model.Calculation

@Composable
fun HistorySection(
    history: List<Calculation>,
    onClearHistory: () -> Unit,
    onItemClick: (String) -> Unit,
    onClose: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "History", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Row {
                TextButton(onClick = onClearHistory) {
                    Text(text = "Clear All")
                }
                TextButton(onClick = onClose) {
                    Text(text = "Close")
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(history) { calculation ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(calculation.result) }
                        .padding(vertical = 8.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(text = calculation.expression, fontSize = 18.sp, color = Color.Gray)
                    Text(text = "= ${calculation.result}", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Divider(modifier = Modifier.padding(top = 8.dp))
                }
            }
        }
    }
}
