# Contributing to Foodike

Thank you for your interest in contributing to Foodike! This guide will help you get started.

## Getting Started

1. Fork the repository
2. Clone your fork:
   ```bash
   git clone https://github.com/<your-username>/Foodike.git
   ```
3. Open the project in Android Studio (Beta 3 or above)
4. Let Gradle sync and download dependencies
5. Build and run on an emulator or device (min SDK 24)

## Development Setup

- **Android SDK:** API 33 (compile and target)
- **JDK:** Java 8 compatibility (`jvmTarget = 1.8`)
- **Build:** `./gradlew assembleDebug`
- **Tests:** `./gradlew test`

## Making Changes

1. Create a new branch from `master`:
   ```bash
   git checkout -b feature/your-feature-name
   ```
2. Make your changes
3. Test your changes on a device or emulator
4. Commit with a clear, descriptive message
5. Push to your fork and open a Pull Request against `master`

## Code Style

- Follow standard [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use Jetpack Compose for all UI (no XML layouts)
- Follow the existing MVVM pattern: each screen should have its own ViewModel, state class, and event sealed class
- Place new dependencies in the Hilt `AppModule` (`di/AppModule.kt`)
- Use `StateFlow` for exposing UI state from ViewModels

## Project Structure

```
app/src/main/java/com/example/foodike/
├── data/           # Repository implementations, fake data sources
├── di/             # Dagger Hilt dependency injection modules
├── domain/         # Models and repository interfaces
├── presentation/   # Screens, ViewModels, UI components
└── ui/theme/       # Material theme (colors, shapes, typography)
```

## Reporting Issues

- Use [GitHub Issues](https://github.com/gautam84/Foodike/issues) to report bugs or suggest features
- Include steps to reproduce for bug reports
- Include device/emulator info and Android version if relevant

## Pull Request Guidelines

- Keep PRs focused on a single change
- Ensure the project builds without errors before submitting
- Include a description of what changed and why
- Link any related issues

## License

By contributing, you agree that your contributions will be licensed under the [MIT License](LICENSE).