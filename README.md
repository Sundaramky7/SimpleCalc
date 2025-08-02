# SimpleCalc 
![Static Badge]()
[![Android Studio](https://img.shields.io/badge/platform-Android_Studio-lightgreen)](https://developer.android.com/studio)

A simple and stylish calculator app for Android, designed with a modern, iOS-inspired interface. This app provides basic arithmetic operations with a user-friendly layout and real-time calculation updates.

## 📸 Screenshots

| Light Mode | Dark Mode |
| :---: | :---: |
|  <img src="https://github.com/user-attachments/assets/275a1fc0-7601-4a16-89a4-33cc8747f34c" width="150" />   <img src="https://github.com/user-attachments/assets/f6f9f605-9774-4ff2-8708-cdb8ea6637be" width="150" />  | <img src="https://github.com/user-attachments/assets/784fa40b-aaa3-4a47-8d3e-7e7fb9b5819c" width="150"/>   <img src="https://github.com/user-attachments/assets/e37c52c1-d68a-4a6c-a71f-186d7a24ce0b" width="150"/>  |

## ✨ Features

- **Modern, iOS-inspired UI:** A clean and intuitive design that makes calculations easy and enjoyable.
- **Real-time calculations:** See the result of your expression as you type.
- **Basic arithmetic operations:**
  - Addition (`+`)
  - Subtraction (`-`)
  - Multiplication (`×`)
  - Division (`÷`)
- **Core functionality:**
  - **Clear (C):** Clears the entire expression and result.
  - **Backspace (⌫):** Deletes the last character from the expression.
  - **Decimal (.)** a real number can be use
  - **Negative Numbers:** Supports negative numbers at the beginning of an expression.
- **Responsive layout:** The UI is designed to work seamlessly in portrait mode.
- **Button press animations:** Subtle animations on button presses provide satisfying visual feedback.

## 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

- **Android Studio:** Make sure you have the latest version of Android Studio installed.
- **Android SDK:** You will need the Android SDK installed and configured.
- **Java Development Kit (JDK):** Ensure you have a compatible JDK installed.

### Installation & Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/your-username/calculator-app.git
   ```
2. **Open in Android Studio:**
   - Open Android Studio.
   - Click on **"Open an Existing Project"**.
   - Navigate to the cloned repository and select the `Calculator` folder.
3. **Build the project:**
   - Android Studio will automatically sync the Gradle files.
   - Once the sync is complete, click the **"Run"** button (green play icon) or use the shortcut `Shift + F10` to build and run the app on an emulator or a physical device.

## 🛠️ Built With

- **Java:** The core application logic is written in Java.
- **XML:** Used for designing the user interface and layouts.
- **Android SDK:** The official software development kit for Android.
- **Android Studio:** The official integrated development environment (IDE) for Android app development.
- **Gradle:** The build automation tool used for building the project.

## 📂 Project Structure

The project follows the standard Android application structure:

```
Calculator/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/calculator/
│   │   │   │   └── MainActivity.java   # Core application logic
│   │   │   ├── res/
│   │   │   │   ├── drawable/           # Custom button backgrounds
│   │   │   │   ├── layout/
│   │   │   │   │   └── ios_calculator_ui.xml # Main UI layout
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml      # Color definitions
│   │   │   │   │   ├── strings.xml     # String resources
│   │   │   │   │   └── themes.xml      # App themes
│   │   │   └── AndroidManifest.xml   # App manifest
│   └── build.gradle.kts              # App-level build script
└── build.gradle.kts                  # Project-level build script
```


