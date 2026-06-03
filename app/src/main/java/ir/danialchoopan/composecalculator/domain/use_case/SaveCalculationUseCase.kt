package ir.danialchoopan.composecalculator.domain.use_case

import ir.danialchoopan.composecalculator.domain.model.Calculation
import ir.danialchoopan.composecalculator.domain.repository.CalculatorRepository

class SaveCalculationUseCase(
    private val repository: CalculatorRepository
) {
    suspend operator fun invoke(calculation: Calculation) {
        repository.insertCalculation(calculation)
    }
}
