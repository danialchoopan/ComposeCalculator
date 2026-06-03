package ir.danialchoopan.composecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import ir.danialchoopan.composecalculator.data.audio.SoundManager
import ir.danialchoopan.composecalculator.data.local.AppDatabase
import ir.danialchoopan.composecalculator.data.repository.CalculatorRepositoryImpl
import ir.danialchoopan.composecalculator.domain.use_case.*
import ir.danialchoopan.composecalculator.presentation.CalculatorScreen
import ir.danialchoopan.composecalculator.presentation.CalculatorViewModel
import ir.danialchoopan.composecalculator.ui.theme.ComposeCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()

        val soundManager = SoundManager(applicationContext)
        val repository = CalculatorRepositoryImpl(db.calculationDao, soundManager)

        val viewModelFactory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CalculatorViewModel(
                    CalculateExpressionUseCase(),
                    GetHistoryUseCase(repository),
                    ClearHistoryUseCase(repository),
                    SaveCalculationUseCase(repository),
                    PlaySoundUseCase(repository)
                ) as T
            }
        }

        setContent {
            ComposeCalculatorTheme {
                val viewModel = ViewModelProvider(this, viewModelFactory)[CalculatorViewModel::class.java]
                val state by viewModel.state.collectAsState()
                CalculatorScreen(
                    state = state,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}
