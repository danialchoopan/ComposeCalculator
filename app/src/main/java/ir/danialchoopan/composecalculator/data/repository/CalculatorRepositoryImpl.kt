package ir.danialchoopan.composecalculator.data.repository

import ir.danialchoopan.composecalculator.data.local.CalculationDao
import ir.danialchoopan.composecalculator.data.local.CalculationEntity
import ir.danialchoopan.composecalculator.data.audio.SoundManager
import ir.danialchoopan.composecalculator.domain.model.Calculation
import ir.danialchoopan.composecalculator.domain.repository.CalculatorRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CalculatorRepositoryImpl(
    private val dao: CalculationDao,
    private val soundManager: SoundManager
) : CalculatorRepository {

    override fun getHistory(): Flow<List<Calculation>> {
        return dao.getHistory().map { entities ->
            entities.map { it.toCalculation() }
        }
    }

    override suspend fun insertCalculation(calculation: Calculation) {
        dao.insertCalculation(CalculationEntity.fromCalculation(calculation))
    }

    override suspend fun clearHistory() {
        dao.clearHistory()
    }

    override fun playSound() {
        soundManager.playSound()
    }
}
