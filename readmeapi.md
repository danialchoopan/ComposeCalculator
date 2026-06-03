# مستندات معماری و دیتابیس ماشین‌حساب (Architecture & Database Documentation)

## مرور کلی معماری (Architecture Overview)

این پروژه از اصول **معماری پاک (Clean Architecture)** پیروی می‌کند که جدایی وظایف، قابلیت نگهداری و تست‌پذیری کد را تضمین می‌کند.

### ۱. لایه Domain
هسته مرکزی اپلیکیشن که شامل منطق کسب‌وکار و مدل‌ها است. این لایه کاملاً Kotlin خالص است و وابستگی به فریم‌ورک اندروید ندارد.
- **مدل‌ها (Models):** `Calculation`, `CalculatorOperation`
- **اینترفیس ریپازیتوری:** `CalculatorRepository`
- **موارد استفاده (Use Cases):**
    - `CalculateExpressionUseCase`: مدیریت ارزیابی محاسبات ریاضی.
    - `GetHistoryUseCase`: بازیابی تاریخچه محاسبات.
    - `ClearHistoryUseCase`: پاک‌سازی کل تاریخچه.
    - `SaveCalculationUseCase`: ذخیره یک محاسبه جدید.
    - `PlaySoundUseCase`: اجرای بازخورد صوتی.

### ۲. لایه Data
مدیریت ذخیره‌سازی داده‌ها و تعامل با فریم‌ورک‌های خارجی.
- **ذخیره‌سازی محلی (Room Database):**
    - `CalculationEntity`: مدل دیتابیس برای Room.
    - `CalculationDao`: شیء دسترسی به داده‌ها برای عملیات تاریخچه.
    - `AppDatabase`: پیکربندی دیتابیس Room.
- **پیاده‌سازی ریپازیتوری:** `CalculatorRepositoryImpl` لایه Domain را به منابع داده متصل می‌کند.
- **مدیریت صدا (Audio Management):** `SoundManager` پخش صدای کلیک را با استفاده از `AudioManager` اندروید مدیریت می‌کند.

### ۳. لایه Presentation
مدیریت رابط کاربری و تعاملات کاربر با استفاده از Jetpack Compose.
- **الگوی MVI/MVVM:** کلاس `CalculatorViewModel` وضعیت (State) را با استفاده از `StateFlow` مدیریت کرده و رویدادهای `CalculatorEvent` را پردازش می‌کند.
- **اجزای UI:** توابع Compose ماژولار مانند `CalculatorButton` ، `DisplaySection` و `HistorySection`.
- **تم (Theme):** پیاده‌سازی Material 3 برای ظاهری مدرن.

---

## ساختار جداول دیتابیس (Database Schema)

### Table: `history`
| فیلد (Field) | نوع (Type) | توضیحات |
|---|---|---|
| `id` | Integer (PK) | شناسه منحصر‌به‌فرد خودکار. |
| `expression` | String | عبارت ریاضی وارد شده توسط کاربر. |
| `result` | String | نتیجه محاسبه شده عبارت. |
| `timestamp` | Long | زمان انجام محاسبه. |

---

## بازخورد صوتی (Audio Feedback)
از طریق `SoundManager` در لایه دیتا مدیریت می‌شود. این کلاس از `audioManager.playSoundEffect(AudioManager.FX_KEY_CLICK)` برای ارائه صدای کلیک استاندارد سیستم هنگام فشردن دکمه‌ها استفاده می‌کند.

---
---

# Calculator Architecture & Database Documentation (English Version)

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
