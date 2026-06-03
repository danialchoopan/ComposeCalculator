package ir.danialchoopan.composecalculator.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.danialchoopan.composecalculator.domain.model.Calculation

@Entity(tableName = "history")
data class CalculationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val expression: String,
    val result: String,
    val timestamp: Long
) {
    fun toCalculation(): Calculation {
        return Calculation(
            id = id,
            expression = expression,
            result = result,
            timestamp = timestamp
        )
    }

    companion object {
        fun fromCalculation(calculation: Calculation): CalculationEntity {
            return CalculationEntity(
                id = calculation.id,
                expression = calculation.expression,
                result = calculation.result,
                timestamp = calculation.timestamp
            )
        }
    }
}
