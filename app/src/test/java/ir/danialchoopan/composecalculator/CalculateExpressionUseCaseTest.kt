package ir.danialchoopan.composecalculator

import ir.danialchoopan.composecalculator.domain.use_case.CalculateExpressionUseCase
import org.junit.Test
import org.junit.Assert.*

class CalculateExpressionUseCaseTest {

    private val calculateExpressionUseCase = CalculateExpressionUseCase()

    @Test
    fun `Test simple addition`() {
        val result = calculateExpressionUseCase("2+2")
        assertEquals("4", result)
    }

    @Test
    fun `Test multiplication`() {
        val result = calculateExpressionUseCase("5x6")
        assertEquals("30", result)
    }

    @Test
    fun `Test scientific sin`() {
        val result = calculateExpressionUseCase("sin(90)")
        assertEquals("1", result)
    }

    @Test
    fun `Test scientific log`() {
        val result = calculateExpressionUseCase("log(100)")
        assertEquals("2", result)
    }

    @Test
    fun `Test power`() {
        val result = calculateExpressionUseCase("2^3")
        assertEquals("8", result)
    }

    @Test
    fun `Test root`() {
        val result = calculateExpressionUseCase("√16")
        assertEquals("4", result)
    }
}
