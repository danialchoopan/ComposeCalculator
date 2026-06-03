package ir.danialchoopan.composecalculator.domain.use_case

import ir.danialchoopan.composecalculator.domain.model.Calculation
import ir.danialchoopan.composecalculator.domain.repository.CalculatorRepository
import kotlinx.coroutines.flow.Flow

class GetHistoryUseCase(
    private val repository: CalculatorRepository
) {
    operator fun invoke(): Flow<List<Calculation>> {
        return repository.getHistory()
    }
}
