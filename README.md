This is a Kotlin Multiplatform project targeting Android, iOS.


<p align="center">
  <img src="https://github.com/mahdizareeii/ComposeMultiplatform/blob/main/screenshot/screen_shot_home_screen.png" width="30%" title="Home Screen" />
  <img src="https://github.com/mahdizareeii/ComposeMultiplatform/blob/main/screenshot/screen_shot_listing_screen.png" width="30%" title="Listing Screen" />
  <img src="https://github.com/mahdizareeii/ComposeMultiplatform/blob/main/screenshot/screen_shot_map_screen.png" width="30%" title="Map Screen" />
</p>

What's Inside
Kotlin Multiplatform (KMP) setup
Jetpack Compose for cross-platform UI
Real architecture with actual code structure

Core Tech Stack
Kotlin Multiplatform: Write once, run on both platforms
Jetpack Compose: Modern UI toolkit
Koin: Lightweight DI framework
Ktor: HTTP client for networking
Coil: Image loading
Google Maps: Map integration

```
composeApp/
├── src/
│   ├── commonMain/                   # Shared code
│   │   ├── kotlin/org/cmp/app/
│   │   │   ├── app/
│   │   │   │   ├── component/        # Reusable UI components
│   │   │   │   ├── screen/           # Main screens
│   │   │   │   └── core/             # Business logic
│   │   │   │       ├── domain/       # Business rules
│   │   │   │       ├── data/         # Data sources
│   │   │   │       └── repository/   # Data access
│   ├── androidMain/                  # Android-specific code
│   └── iosMain/                      # iOS-specific code
```

## 🔑 Key Features

- **Platform-Specific Code**
  - Uses `expect`/`actual` declarations for platform-specific implementations
  - Example: `MapViewComponent` has different implementations for Android and iOS

- **Clean Architecture**
  - **Domain layer**: Business logic and models
  - **Data layer**: Network and local storage
  - **Presentation layer**: UI components and screens

- **Dependency Injection**
  - Uses **Koin** for managing dependencies
  - Separate modules for different features

- **Real Implementation Details**
  - **Network Layer**: Ktor client with platform-specific engines
  - **UI Components**: Shared Compose components with platform-specific adaptations





* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
