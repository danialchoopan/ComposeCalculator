package ir.danialchoopan.composecalculator.domain.repository

import ir.danialchoopan.composecalculator.domain.model.Calculation
import kotlinx.coroutines.flow.Flow

interface CalculatorRepository {
    fun getHistory(): Flow<List<Calculation>>
    suspend fun insertCalculation(calculation: Calculation)
    suspend fun clearHistory()
    fun playSound()
}
