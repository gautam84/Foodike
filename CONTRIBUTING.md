# Contributing to Foodike 🍔

First off, thanks for taking the time to contribute! Foodike is an open-source project and we welcome contributions from everyone.

## Getting Started

### Prerequisites

- Android Studio (Beta 3 or above)
- JDK 11 or higher
- Git

### Setup

1. **Fork** the repository on GitHub
2. **Clone** your fork locally:
   ```bash
   git clone https://github.com/YOUR_USERNAME/Foodike.git
   ```
3. **Open** the project in Android Studio
4. **Sync** Gradle and let dependencies download
5. **Run** the app on an emulator or physical device to verify everything works

## How to Contribute

### Reporting Bugs

- Check [existing issues](https://github.com/gautam84/Foodike/issues) first to avoid duplicates
- Open a new issue with a clear title and description
- Include steps to reproduce, expected behavior, and actual behavior
- Add screenshots or screen recordings if applicable
- Mention your device, Android version, and app version

### Suggesting Features

- Open an issue with the **[Feature Request]** tag in the title
- Describe the feature and why it would be useful
- Include mockups or references if possible

### Submitting Code

1. Create a new branch from `master`:
   ```bash
   git checkout -b feature/your-feature-name
   ```
2. Make your changes
3. Test thoroughly on at least one device/emulator
4. Commit with clear, descriptive messages:
   ```bash
   git commit -m "Add: brief description of what you added"
   ```
5. Push to your fork:
   ```bash
   git push origin feature/your-feature-name
   ```
6. Open a **Pull Request** against `master` with:
   - A clear description of what changed and why
   - Screenshots/recordings for UI changes
   - Reference to any related issues

## Code Style

- **Language**: Kotlin (100%)
- **Architecture**: MVVM — keep ViewModels, Repositories, and UI layers separate
- **UI**: Jetpack Compose — no XML layouts
- **DI**: Dagger-Hilt for dependency injection
- **Async**: Coroutines + Flow/StateFlow — no RxJava or callbacks
- **Naming**: Follow standard Kotlin conventions
   - `camelCase` for functions and variables
   - `PascalCase` for classes and composables
   - Descriptive names over abbreviations

## Project Structure

```
app/
├── data/          # Data models, repositories, data sources
├── di/            # Hilt modules and dependency injection setup
├── presentation/  # UI screens, composables, and ViewModels
├── navigation/    # Navigation graph and routes
└── ui/theme/      # Theme, colors, typography
```

## What Can You Work On?

Check out the **Issues** tab for open tasks. Issues labeled `good first issue` are great starting points for new contributors. If you want to work on something not listed, open an issue first so we can discuss.

## Communication

- **Issues**: For bugs, features, and discussions
- **Pull Requests**: For code contributions
- **Email**: gautamhazarika01@gmail.com for anything else

## Code of Conduct

Be respectful, constructive, and inclusive. We're all here to learn and build something cool together.

---

Thanks for contributing! Every PR, issue, and suggestion makes Foodike better. 🚀