package ir.danialchoopan.composecalculator

data class CalculatorStateDataClass(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperationSealed? = null
)
