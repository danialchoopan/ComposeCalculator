package ir.danialchoopan.composecalculator.domain.use_case

import ir.danialchoopan.composecalculator.domain.repository.CalculatorRepository

class ClearHistoryUseCase(
    private val repository: CalculatorRepository
) {
    suspend operator fun invoke() {
        repository.clearHistory()
    }
}
