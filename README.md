# Esmalar
Esmalar is a modern Android app built with Kotlin and Jetpack Compose. It maps Arabic letters and names to predefined Esma results, saves user input with SharedPreferences, and provides a clean Material 3 interface with editable text and a simple, user-friendly design.
# Esmalar

**Esmalar** is an Android application built with **Kotlin and Jetpack Compose** that provides a simple and user-friendly interface for entering Arabic letters or names and displaying their corresponding mapped names.

## Features

* ✨ Enter Arabic letters or names through a modern text field.
* 🔤 Automatically display the corresponding name based on the predefined `NameMap`.
* 🧹 Clear the entered text with a single tap.
* 💾 Automatically save the user's last input using `SharedPreferences`.
* 🔄 Restore the saved input automatically when the application is reopened.
* 📝 Editable text area for displaying and modifying the associated `hukam` text.
* 🎨 Modern UI using **Jetpack Compose** with a transparent surface and vertical gradient background.
* 📱 Edge-to-edge Android UI support.
* 🌙 Designed to work with Android's modern Material 3 UI components.

## Technologies Used

* **Kotlin**
* **Jetpack Compose**
* **Material 3**
* **SharedPreferences**
* **AndroidX**
* **Gradle**
* **Android Studio**

## Project Structure

The application uses a Compose-based UI architecture. The main screen contains:

1. **Name Input** – Allows the user to enter an Arabic letter or name.
2. **Mapped Name Output** – Uses `NameMap.getMappedName()` to display the corresponding result.
3. **Hukam Text** – Displays editable text associated with the selected input.
4. **Persistent Storage** – Saves and restores the user's input using Android `SharedPreferences`.

## Example

The application can map an entered Arabic letter to its corresponding name according to the application's predefined mapping:

```text
ا → Ya Allah
ب → Ya Baki
...
```

The mapping can be customized in the `NameMap` class.

## Purpose

Esmalar is intended as a lightweight Android application for working with predefined Arabic-letter/name mappings while providing a clean, simple, and modern Compose-based user interface.

## License

This project is currently intended for educational and personal use.
