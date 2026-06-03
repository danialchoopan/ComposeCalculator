# ماشین‌حساب پیشرفته (Advanced-Calculator)

یک اپلیکیشن ماشین‌حساب مدرن و نیتیو اندروید که با **Jetpack Compose** و بر پایه اصول **معماری پاک (Clean Architecture)** ساخته شده است.

## قابلیت‌ها (Features)

- **حالت معمولی (Simple Mode):** عملیات پایه ریاضی شامل جمع، تفریق، ضرب، تقسیم و درصد.
- **حالت پیشرفته (Scientific Mode):** عملیات پیشرفته مانند سینوس، کسینوس، تانژانت، لگاریتم، توان و رادیکال.
- **سیستم تاریخچه (History):** ذخیره خودکار محاسبات. امکان مشاهده، استفاده مجدد از نتایج یا پاک‌سازی کل تاریخچه.
- **بازخورد صوتی (Audio Feedback):** پخش صدای کلیک دلپذیر هنگام فشردن هر دکمه برای بهبود تجربه کاربری.
- **رابط کاربری Material 3:** طراحی مدرن با پشتیبانی از رنگ‌های پویا (در اندروید ۱۲ به بالا).

## تکنولوژی‌های مورد استفاده (Tech Stack)

- **رابط کاربری:** Jetpack Compose
- **معماری:** Clean Architecture (Domain, Data, Presentation)
- **دیتابیس:** Room Database
- **برنامه‌نویسی ناهمگام:** Kotlin Coroutines & Flow
- **اجزای UI:** Material 3
- **زبان:** Kotlin

## اسکرین‌شات‌های برنامه (UI Screenshots)

| حالت معمولی | حالت پیشرفته | تاریخچه |
|---|---|---|
| ![Calculator Simple Mode](./screenshots/simple_mode.png) | ![Calculator Scientific Mode](./screenshots/scientific_mode.png) | ![Calculator History](./screenshots/history.png) |

## راهنمای نصب و اجرا (Getting Started)

### پیش‌نیازها
- Android Studio Chipmunk یا نسخه‌های جدیدتر.
- Android SDK 26 (Android 8.0) یا بالاتر.

### مراحل نصب
1. **کلون کردن پروژه:**
   ```bash
   git clone https://github.com/yourusername/Advanced-Calculator.git
   ```
2. **باز کردن در Android Studio:**
   اندروید استودیو را اجرا کرده و گزینه "Open" را انتخاب کنید و به پوشه پروژه بروید.
3. **بیلد کردن پروژه:**
   منتظر بمانید تا Gradle سینک شود. سپس از منوی `Build > Make Project` را بزنید.
4. **اجرای اپلیکیشن:**
   شبیه‌ساز یا دستگاه واقعی خود را انتخاب کرده و دکمه **Run** (مثلث سبز) را بزنید.

## ساختار پروژه
توضیحات دقیق در مورد معماری و دیتابیس در فایل [readmeapi.md](./readmeapi.md) موجود است.

---
---

# Advanced-Calculator (English Version)

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
