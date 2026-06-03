package ir.danialchoopan.composecalculator.domain.model

sealed class CalculatorOperation(val symbol: String) {
    object Add : CalculatorOperation("+")
    object Subtract : CalculatorOperation("-")
    object Multiply : CalculatorOperation("x")
    object Divide : CalculatorOperation("/")
    object Power : CalculatorOperation("^")
    object Root : CalculatorOperation("√")
    object Log : CalculatorOperation("log")
    object Sin : CalculatorOperation("sin")
    object Cos : CalculatorOperation("cos")
    object Tan : CalculatorOperation("tan")
}
