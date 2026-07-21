# Calendar Time Calculator - Android App

A comprehensive Android application for calculating time differences between dates and performing date/time arithmetic operations with an intuitive Material Design interface.

<img width="523" height="737" alt="image" src="https://github.com/user-attachments/assets/cfa9e68f-3cd7-41d2-b0fe-26ff18f8222f" />

## Features

### Time Difference Calculator
- Calculate exact differences between two dates and times
- Display results in days, hours, minutes, and seconds
- Visual formatting with emoji icons for better readability
- Input validation to ensure correct date/time formats

### Date/Time Arithmetic
- Add or subtract days, hours, and minutes from any date/time
- Select between "Add Time" and "Subtract Time" operations
- Interactive dialog for entering amounts to add/subtract
- Display original and resulting date/time side by side

### User Interface
- Clean Material Design implementation
- Native Android date and time pickers
- Responsive layout that works on all screen sizes
- Clear visual separation between different features
- Dark theme support ready

## Technologies Used

- **Kotlin** - Primary programming language
- **Android SDK** - Android application development framework
- **Material Design Components** - UI components and styling
- **View Binding** - Type-safe view access
- **Calendar API** - Date/time manipulation and calculations

## Prerequisites

Before you begin, ensure you have the following installed:

- **Java 17+** - Required for Android development
- **Android SDK** - Android development tools
- **Android Studio** (Recommended) or **VS Code** with Android extensions

### For VS Code Users
We recommend installing the **Caspian Emulator** extension for easy setup without Android Studio.

## Getting Started

### Clone the Repository
```bash
git clone https://github.com/yourusername/calendar-time-calculator.git
cd calendar-time-calculator
```

### VS Code Setup
If using VS Code with the Caspian Emulator extension:
1. Install the **Caspian Emulator** extension from the VS Code marketplace
2. Click the phone icon in the activity bar
3. Follow the prompts to download and install the Android SDK
4. Create a new AVD (Android Virtual Device)
5. Use the command `Android: Run on Device/Emulator` to launch the app

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/example/calendartimecalculator/
│   │   │   └── MainActivity.kt          # Main application logic
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml    # Main layout
│   │   │   │   └── dialog_amount.xml    # Amount input dialog
│   │   │   ├── drawable/
│   │   │   │   ├── ic_calendar.xml      # Calendar icon
│   │   │   │   ├── ic_time.xml          # Time icon
│   │   │   │   ├── ic_calculate.xml     # Calculate icon
│   │   │   │   ├── ic_operation.xml     # Operation icon
│   │   │   │   └── ic_clear.xml         # Clear icon
│   │   │   └── values/
│   │   │       ├── colors.xml           # Color definitions
│   │   │       └── themes.xml           # Theme configuration
│   └── AndroidManifest.xml               # App manifest
├── build.gradle                          # App-level build configuration
└── build.gradle                          # Project-level build configuration
```

## Usage Examples

### Calculate Time Difference
1. Enter the "From" date and time
2. Enter the "To" date and time
3. Click "Calculate Difference"
4. View the result showing the exact time difference

### Add Time to a Date
1. Select "Add Time" from the dropdown
2. Enter the starting date and time
3. Click "Execute Operation"
4. Enter the amount to add (days, hours, minutes)
5. View the resulting date and time

### Subtract Time from a Date
1. Select "Subtract Time" from the dropdown
2. Enter the starting date and time
3. Click "Execute Operation"
4. Enter the amount to subtract
5. View the resulting date and time

## Key Features Explained

### Date/Time Validation
The app validates all inputs to ensure:
- Correct date format (DD/MM/YYYY)
- Valid time format (HH:MM)
- "To" date/time is after "From" date/time

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Android Open Source Project
- Material Design Components team
- All contributors and testers
