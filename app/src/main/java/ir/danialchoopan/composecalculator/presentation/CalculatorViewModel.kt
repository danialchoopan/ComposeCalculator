package ir.danialchoopan.composecalculator.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.danialchoopan.composecalculator.domain.model.Calculation
import ir.danialchoopan.composecalculator.domain.model.CalculatorOperation
import ir.danialchoopan.composecalculator.domain.use_case.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CalculatorViewModel(
    private val calculateExpressionUseCase: CalculateExpressionUseCase,
    private val getHistoryUseCase: GetHistoryUseCase,
    private val clearHistoryUseCase: ClearHistoryUseCase,
    private val saveCalculationUseCase: SaveCalculationUseCase,
    private val playSoundUseCase: PlaySoundUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CalculatorState())
    val state: StateFlow<CalculatorState> = _state.asStateFlow()

    init {
        getHistory()
    }

    fun onEvent(event: CalculatorEvent) {
        playSoundUseCase()
        when (event) {
            is CalculatorEvent.Number -> enterNumber(event.number)
            is CalculatorEvent.Operation -> enterOperation(event.operation)
            is CalculatorEvent.Symbol -> enterSymbol(event.symbol)
            is CalculatorEvent.Decimal -> enterDecimal()
            is CalculatorEvent.Clear -> _state.update { it.copy(expression = "", result = "") }
            is CalculatorEvent.Delete -> deleteLast()
            is CalculatorEvent.Calculate -> performCalculation()
            is CalculatorEvent.ToggleHistory -> _state.update { it.copy(isHistoryVisible = !it.isHistoryVisible) }
            is CalculatorEvent.ToggleMode -> _state.update { it.copy(isScientificMode = !it.isScientificMode) }
            is CalculatorEvent.ClearHistory -> clearHistory()
            is CalculatorEvent.UseHistoryResult -> _state.update { it.copy(expression = event.result, isHistoryVisible = false) }
            is CalculatorEvent.ToggleSign -> toggleSign()
        }
    }

    private fun enterNumber(number: Int) {
        _state.update { it.copy(expression = it.expression + number) }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        _state.update { it.copy(expression = it.expression + operation.symbol) }
    }

    private fun enterSymbol(symbol: String) {
        _state.update { it.copy(expression = it.expression + symbol) }
    }

    private fun enterDecimal() {
        _state.update { it.copy(expression = it.expression + ".") }
    }

    private fun toggleSign() {
        _state.update {
            if (it.expression.startsWith("-")) {
                it.copy(expression = it.expression.drop(1))
            } else {
                it.copy(expression = "-" + it.expression)
            }
        }
    }

    private fun deleteLast() {
        _state.update {
            if (it.expression.isNotBlank()) {
                it.copy(expression = it.expression.dropLast(1))
            } else it
        }
    }

    private fun performCalculation() {
        val expression = _state.value.expression
        if (expression.isBlank()) return

        val result = calculateExpressionUseCase(expression)
        _state.update { it.copy(result = result) }

        if (result != "Error") {
            viewModelScope.launch {
                saveCalculationUseCase(
                    Calculation(
                        expression = expression,
                        result = result
                    )
                )
            }
        }
    }

    private fun getHistory() {
        getHistoryUseCase()
            .onEach { history ->
                _state.update { it.copy(history = history) }
            }
            .launchIn(viewModelScope)
    }

    private fun clearHistory() {
        viewModelScope.launch {
            clearHistoryUseCase()
        }
    }
}
