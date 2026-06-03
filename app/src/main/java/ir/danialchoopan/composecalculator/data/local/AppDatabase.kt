package ir.danialchoopan.composecalculator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CalculationEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val calculationDao: CalculationDao

    companion object {
        const val DATABASE_NAME = "calculator_db"
    }
}
