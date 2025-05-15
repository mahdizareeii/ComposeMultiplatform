This is a Kotlin Multiplatform project targeting Android, iOS.


<p align="center">
  <img src="https://github.com/mahdizareeii/ComposeMultiplatform/blob/main/screenshot/screen_shot_listing_screen.png" width="50%" title="Listing Screen" />
  <img src="https://github.com/mahdizareeii/ComposeMultiplatform/blob/main/screenshot/screen_shot_map_screen.png" width="50%" title="Map Screen" />
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

## 🚀 Why Kotlin Multiplatform (KMP)?

### ✅ 1. Real Performance Benefits
- **Native Performance**: Uses platform-specific implementations where it matters
- **Small Binary Size**: Only shared code is compiled for both platforms
- **Direct Platform Access**: Can still use native APIs when needed

### ⚡ 2. Development Efficiency
- **Single Codebase**: Write business logic once, use everywhere
- **Faster Development**: Changes in shared code automatically apply to both platforms
- **Consistent Behavior**: Same business logic means same behavior across platforms

### 🎨 3. UI Development
- **Jetpack Compose**: Modern declarative UI toolkit
- **Platform-Specific UI**: Can use native UI components when needed
- **Shared Components**: Reuse UI logic across platforms

### 🔧 4. Easy Integration
- **Gradle Setup**: Familiar build system
- **CocoaPods**: Standard iOS dependency management
- **Platform-Specific Code**: Can still write native code when needed

### 🔄 5. Maintenance Benefits
- **Single Source of Truth**: Business logic in one place
- **Easier Testing**: Shared code means shared tests
- **Consistent Updates**: Update once, deploy everywhere

### 💰 6. Real Cost Benefits
- **Reduced Development Time**: Write once, run everywhere
- **Smaller Team Size**: One team can handle both platforms
- **Faster Time to Market**: Develop features once for both platforms

### 📘 7. Learning Curve
- **Kotlin**: Similar to Swift/Java
- **Compose**: Similar to SwiftUI
- **Architecture**: Similar to native patterns

---

## ✅ Real-World Proof

- **Production Ready**: Used in real applications
- **Scalable**: Can grow with your needs
- **Community Support**: Active development and support

> This project shows that **KMP isn't just a theoretical solution** – it's a **practical approach** that can save time and resources while maintaining the **quality and performance** native developers expect.



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
