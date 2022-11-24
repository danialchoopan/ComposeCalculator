package ir.danialchoopan.composecalculator

sealed class CalculatorOperationSealed(val symbol: String) {
    object Add : CalculatorOperationSealed("+")
    object Subtract : CalculatorOperationSealed("-")
    object Multiply : CalculatorOperationSealed("x")
    object Divide : CalculatorOperationSealed("/")
}
