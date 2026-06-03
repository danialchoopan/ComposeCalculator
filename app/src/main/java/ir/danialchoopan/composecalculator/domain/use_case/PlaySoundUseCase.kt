package ir.danialchoopan.composecalculator.domain.use_case

import ir.danialchoopan.composecalculator.domain.repository.CalculatorRepository

class PlaySoundUseCase(
    private val repository: CalculatorRepository
) {
    operator fun invoke() {
        repository.playSound()
    }
}
