package ir.danialchoopan.composecalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorStateDataClass())
        private set

    fun onAction(action: CalculatorActionSealed) {
        when (action) {
            is CalculatorActionSealed.Number -> enterNumber(action.number)
            is CalculatorActionSealed.Decimal -> enterDecimal()
            is CalculatorActionSealed.Clear -> state = CalculatorStateDataClass()
            is CalculatorActionSealed.Operation -> enterOperation(action.calculatorOperationSealed)
            is CalculatorActionSealed.Calculate -> performCalculation()
            is CalculatorActionSealed.Delete -> performDeletion()
        }
    }

    private fun performDeletion() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )

        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperationSealed.Add -> number1 + number2
                is CalculatorOperationSealed.Subtract -> number1 - number2
                is CalculatorOperationSealed.Multiply -> number1 * number2
                is CalculatorOperationSealed.Divide -> number1 / number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }

    }

    private fun enterOperation(calculatorOperationSealed: CalculatorOperationSealed) {
        if (state.number1.isNotBlank()) {
            state = state.copy(operation = calculatorOperationSealed)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number1 = state.number2 + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= 8) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= 8) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )

    }

}