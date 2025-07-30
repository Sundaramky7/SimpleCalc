# Calculator App

A simple and stylish calculator app for Android, designed with a modern, iOS-inspired interface. This app provides basic arithmetic operations with a user-friendly layout and real-time calculation updates.

## 📸 Screenshots

*(You can add screenshots of your app here to showcase the UI. Here are some examples of what you could show.)*

| Light Mode | Dark Mode |
| :---: | :---: |
| *[![WhatsApp Image 2025-07-30 at 21 22 32 (1)](https://github.com/user-attachments/assets/cdcd16fb-eea9-4f5a-a388-d4224bf23de1)
]* | *[![Uploading WhatsApp Image 2025-07-30 at 21.22.33 (1).jpeg…]()
]* |

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


