package ir.danialchoopan.composecalculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ir.danialchoopan.composecalculator.domain.model.CalculatorOperation
import ir.danialchoopan.composecalculator.presentation.components.*
import ir.danialchoopan.composecalculator.ui.theme.LightGray
import ir.danialchoopan.composecalculator.ui.theme.MediumGray
import ir.danialchoopan.composecalculator.ui.theme.Orange

@Composable
fun CalculatorScreen(
    state: CalculatorState,
    onEvent: (CalculatorEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { onEvent(CalculatorEvent.ToggleMode) }) {
                    Text(
                        text = if (state.isScientificMode) "Simple" else "Sci",
                        color = Color.White
                    )
                }
                IconButton(onClick = { onEvent(CalculatorEvent.ToggleHistory) }) {
                    Text(text = "Hist", color = Color.White)
                }
            }

            DisplaySection(
                expression = state.expression,
                result = state.result,
                modifier = Modifier.weight(1f)
            )

            if (state.isScientificMode) {
                ScientificButtons(onEvent = onEvent)
            }
            SimpleButtons(onEvent = onEvent)
        }

        if (state.isHistoryVisible) {
            HistorySection(
                history = state.history,
                onClearHistory = { onEvent(CalculatorEvent.ClearHistory) },
                onItemClick = { result -> onEvent(CalculatorEvent.UseHistoryResult(result)) },
                onClose = { onEvent(CalculatorEvent.ToggleHistory) }
            )
        }
    }
}

@Composable
fun SimpleButtons(onEvent: (CalculatorEvent) -> Unit) {
    val spacing = 8.dp
    Column(verticalArrangement = Arrangement.spacedBy(spacing)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacing)
        ) {
            CalculatorButton(
                symbol = "AC",
                modifier = Modifier
                    .background(LightGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Clear) }
            )
            CalculatorButton(
                symbol = "+/-",
                modifier = Modifier
                    .background(LightGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.ToggleSign) }
            )
            CalculatorButton(
                symbol = "%",
                modifier = Modifier
                    .background(LightGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Symbol("/100")) }
            )
            CalculatorButton(
                symbol = "/",
                modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Divide)) }
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacing)
        ) {
            CalculatorButton(
                symbol = "7",
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(7)) }
            )
            CalculatorButton(
                symbol = "8",
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(8)) }
            )
            CalculatorButton(
                symbol = "9",
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(9)) }
            )
            CalculatorButton(
                symbol = "x",
                modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Multiply)) }
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacing)
        ) {
            CalculatorButton(
                symbol = "4",
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(4)) }
            )
            CalculatorButton(
                symbol = "5",
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(5)) }
            )
            CalculatorButton(
                symbol = "6",
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(6)) }
            )
            CalculatorButton(
                symbol = "-",
                modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Subtract)) }
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacing)
        ) {
            CalculatorButton(
                symbol = "1",
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(1)) }
            )
            CalculatorButton(
                symbol = "2",
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(2)) }
            )
            CalculatorButton(
                symbol = "3",
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(3)) }
            )
            CalculatorButton(
                symbol = "+",
                modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Add)) }
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacing)
        ) {
            CalculatorButton(
                symbol = "DEL",
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Delete) }
            )
            CalculatorButton(
                symbol = "0",
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Number(0)) }
            )
            CalculatorButton(
                symbol = ".",
                modifier = Modifier
                    .background(MediumGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Decimal) }
            )
            CalculatorButton(
                symbol = "=",
                modifier = Modifier
                    .background(Orange)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Calculate) }
            )
        }
    }
}

@Composable
fun ScientificButtons(onEvent: (CalculatorEvent) -> Unit) {
    val spacing = 8.dp
    Column(
        modifier = Modifier.padding(bottom = spacing),
        verticalArrangement = Arrangement.spacedBy(spacing)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacing)
        ) {
            CalculatorButton(
                symbol = "sin",
                modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Sin)) }
            )
            CalculatorButton(
                symbol = "cos",
                modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Cos)) }
            )
            CalculatorButton(
                symbol = "tan",
                modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Tan)) }
            )
            CalculatorButton(
                symbol = "log",
                modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Log)) }
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacing)
        ) {
            CalculatorButton(
                symbol = "(",
                modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Symbol("(")) }
            )
            CalculatorButton(
                symbol = ")",
                modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Symbol(")")) }
            )
            CalculatorButton(
                symbol = "^",
                modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Power)) }
            )
            CalculatorButton(
                symbol = "√",
                modifier = Modifier
                    .background(Color.DarkGray)
                    .aspectRatio(1f)
                    .weight(1f),
                onClick = { onEvent(CalculatorEvent.Operation(CalculatorOperation.Root)) }
            )
        }
    }
}
