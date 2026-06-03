# Calculator Architecture & Database Documentation

## Architecture Overview

This project follows the **Clean Architecture** principles, ensuring a separation of concerns and making the codebase more maintainable and testable.

### 1. Domain Layer
The core of the application, containing business logic and models. It is pure Kotlin and has no dependencies on the Android framework.
- **Models:** `Calculation`, `CalculatorOperation`
- **Repository Interface:** `CalculatorRepository`
- **Use Cases:**
    - `CalculateExpressionUseCase`: Handles mathematical evaluation.
    - `GetHistoryUseCase`: Retrieves calculation history.
    - `ClearHistoryUseCase`: Clears all history.
    - `SaveCalculationUseCase`: Persists a new calculation.
    - `PlaySoundUseCase`: Triggers audio feedback.

### 2. Data Layer
Handles data persistence and external framework interactions.
- **Local (Room Database):**
    - `CalculationEntity`: Database model for Room.
    - `CalculationDao`: Data Access Object for history operations.
    - `AppDatabase`: Room database configuration.
- **Repository Implementation:** `CalculatorRepositoryImpl` connects the domain layer with data sources.
- **Audio Management:** `SoundManager` manages playing click sounds using Android's `AudioManager`.

### 3. Presentation Layer
Manages the UI and user interactions using Jetpack Compose.
- **MVI/MVVM:** `CalculatorViewModel` manages state using `StateFlow` and handles `CalculatorEvent`s.
- **UI Components:** Modular Compose functions like `CalculatorButton`, `DisplaySection`, and `HistorySection`.
- **Theme:** Material 3 implementation for a modern look and feel.

## Database Schema

### Table: `history`
| Field | Type | Description |
|---|---|---|
| `id` | Integer (PK) | Auto-generated unique identifier. |
| `expression` | String | The mathematical expression entered by the user. |
| `result` | String | The calculated result of the expression. |
| `timestamp` | Long | Time when the calculation was performed. |

## Audio Feedback
Managed via `SoundManager` in the data layer. It uses `audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK)` to provide a consistent and system-standard click sound upon button presses.
