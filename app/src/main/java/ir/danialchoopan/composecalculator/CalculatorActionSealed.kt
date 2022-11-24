package ir.danialchoopan.composecalculator

sealed class CalculatorActionSealed {
    data class Number(val number: Int) : CalculatorActionSealed()
    object Clear : CalculatorActionSealed()
    object Delete : CalculatorActionSealed()
    object Decimal : CalculatorActionSealed()
    object Calculate : CalculatorActionSealed()
    data class Operation(val calculatorOperationSealed: CalculatorOperationSealed) :
        CalculatorActionSealed()
}
