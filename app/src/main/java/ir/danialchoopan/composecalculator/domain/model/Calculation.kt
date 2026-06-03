package ir.danialchoopan.composecalculator.domain.model

data class Calculation(
    val id: Int? = null,
    val expression: String,
    val result: String,
    val timestamp: Long = System.currentTimeMillis()
)
