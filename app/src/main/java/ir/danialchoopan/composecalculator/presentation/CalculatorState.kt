package ir.danialchoopan.composecalculator.presentation

import ir.danialchoopan.composecalculator.domain.model.Calculation
import ir.danialchoopan.composecalculator.domain.model.CalculatorOperation

data class CalculatorState(
    val expression: String = "",
    val result: String = "",
    val history: List<Calculation> = emptyList(),
    val isHistoryVisible: Boolean = false,
    val isScientificMode: Boolean = false
)
