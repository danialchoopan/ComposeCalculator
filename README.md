# Advanced-Calculator

A modern, native Android calculator built with **Jetpack Compose** and **Clean Architecture**.

## Features

- **Simple Mode:** Basic operations including addition, subtraction, multiplication, division, and decimals.
- **Scientific Mode:** Advanced operations such as Sine, Cosine, Tangent, Logarithm, Power, and Square Root.
- **History System:** Automatically saves your calculations. View, reuse results, or clear the entire history.
- **Audio Feedback:** A satisfying click sound on every button press to enhance user experience.
- **Material 3 UI:** Modern design with dynamic color support (on Android 12+).

## Tech Stack

- **UI:** Jetpack Compose
- **Architecture:** Clean Architecture (Domain, Data, Presentation)
- **Database:** Room Database
- **Asynchronous:** Kotlin Coroutines & Flow
- **UI Components:** Material 3
- **Language:** Kotlin

## UI Screenshots

| Simple Mode | Scientific Mode | History |
|---|---|---|
| ![Calculator Simple Mode](./screenshots/simple_mode.png) | ![Calculator Scientific Mode](./screenshots/scientific_mode.png) | ![Calculator History](./screenshots/history.png) |

## Getting Started & Installation

### Prerequisites
- Android Studio Chipmunk or newer.
- Android SDK 26 (Android 8.0) or higher.

### Installation Steps
1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/Advanced-Calculator.git
   ```
2. **Open in Android Studio:**
   Launch Android Studio and select "Open" to navigate to the project folder.
3. **Build the project:**
   Wait for Gradle to sync. Click on `Build > Make Project`.
4. **Run the app:**
   Select your emulator or connected physical device and click the **Run** icon (Green play button).

## Project Structure
Detailed documentation on architecture and database can be found in [readmeapi.md](./readmeapi.md).
