package ir.danialchoopan.composecalculator.presentation

import ir.danialchoopan.composecalculator.domain.model.CalculatorOperation

sealed class CalculatorEvent {
    data class Number(val number: Int) : CalculatorEvent()
    object Clear : CalculatorEvent()
    object Delete : CalculatorEvent()
    object Decimal : CalculatorEvent()
    object Calculate : CalculatorEvent()
    data class Operation(val operation: CalculatorOperation) : CalculatorEvent()
    data class Symbol(val symbol: String) : CalculatorEvent()
    object ToggleHistory : CalculatorEvent()
    object ToggleMode : CalculatorEvent()
    object ClearHistory : CalculatorEvent()
    data class UseHistoryResult(val result: String) : CalculatorEvent()
    object ToggleSign : CalculatorEvent()
}
