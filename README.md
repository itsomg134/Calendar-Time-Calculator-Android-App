# Calendar Time Calculator - Android App

A comprehensive Android application for calculating time differences between dates and performing date/time arithmetic operations with an intuitive Material Design interface.

## 📱 Features

### 🔍 Time Difference Calculator
- Calculate exact differences between two dates and times
- Display results in days, hours, minutes, and seconds
- Visual formatting with emoji icons for better readability
- Input validation to ensure correct date/time formats

### ➕➖ Date/Time Arithmetic
- Add or subtract days, hours, and minutes from any date/time
- Select between "Add Time" and "Subtract Time" operations
- Interactive dialog for entering amounts to add/subtract
- Display original and resulting date/time side by side

### 🎨 User Interface
- Clean Material Design implementation
- Native Android date and time pickers
- Responsive layout that works on all screen sizes
- Clear visual separation between different features
- Dark theme support ready

## 🛠️ Technologies Used

- **Kotlin** - Primary programming language
- **Android SDK** - Android application development framework
- **Material Design Components** - UI components and styling
- **View Binding** - Type-safe view access
- **Calendar API** - Date/time manipulation and calculations

## 📋 Prerequisites

Before you begin, ensure you have the following installed:

- **Java 17+** - Required for Android development
- **Android SDK** - Android development tools
- **Android Studio** (Recommended) or **VS Code** with Android extensions

### For VS Code Users
We recommend installing the **Caspian Emulator** extension for easy setup without Android Studio.

## 🚀 Getting Started

### Clone the Repository
```bash
git clone https://github.com/yourusername/calendar-time-calculator.git
cd calendar-time-calculator
```

### Open in Android Studio
1. Open Android Studio
2. Select "Open an existing Android Studio project"
3. Navigate to the project directory and select it
4. Wait for Gradle sync to complete

### Run the App
1. Connect a physical device or start an emulator
2. Click the "Run" button (▶) or press `Shift + F10`
3. Select your target device
4. Wait for the app to build and install

### VS Code Setup
If using VS Code with the Caspian Emulator extension:
1. Install the **Caspian Emulator** extension from the VS Code marketplace
2. Click the phone icon in the activity bar
3. Follow the prompts to download and install the Android SDK
4. Create a new AVD (Android Virtual Device)
5. Use the command `Android: Run on Device/Emulator` to launch the app

## 📁 Project Structure

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

## 🔧 Build Configuration

The app uses the following build configuration:

```gradle
android {
    namespace 'com.example.calendartimecalculator'
    compileSdk 34

    defaultConfig {
        applicationId "com.example.calendartimecalculator"
        minSdk 24
        targetSdk 34
        versionCode 1
        versionName "1.0"
    }
}
```

## 📱 App Screenshots

### Main Screen
- **Calculate Difference Section**: Input "From" and "To" dates/times with native pickers
- **Add/Subtract Time Section**: Select operation, enter date/time, and specify amounts
- **Results Display**: Clearly formatted results with visual indicators

### Features in Action
- Date and time pickers open native Android dialogs
- Results show detailed breakdown (days, hours, minutes, seconds)
- Operation dialog allows entering days, hours, and minutes to add/subtract

## 💡 Usage Examples

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

## 🎯 Key Features Explained

### Date/Time Validation
The app validates all inputs to ensure:
- Correct date format (DD/MM/YYYY)
- Valid time format (HH:MM)
- "To" date/time is after "From" date/time

### Result Formatting
Results are displayed with:
- Clear labels for each time unit
- Visual indicators (📅 🕐 ⏱️ ⏲️)
- Total duration summary
- Original input display for reference

### Error Handling
- User-friendly error messages
- Toast notifications for invalid inputs
- Graceful handling of parsing errors

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- Android Open Source Project
- Material Design Components team
- All contributors and testers

## 📞 Support

If you encounter any issues or have questions:
- Open an issue on GitHub
- Check the troubleshooting section below

## 🔧 Troubleshooting

### Common Issues

**Issue**: App won't build
- **Solution**: Ensure you have Java 17+ installed and Gradle synced

**Issue**: Emulator won't start
- **Solution**: Verify that virtualization is enabled in BIOS
- Check that you have enough disk space for the AVD

**Issue**: Date picker doesn't show
- **Solution**: Ensure the app has necessary permissions
- Check that the view IDs match the code

### VS Code Specific
- Install the Caspian Emulator extension for automatic SDK setup
- Use `Ctrl+Shift+P` and search for "Android" commands
- Ensure the Android SDK path is correctly set

## 🚀 Future Improvements

- [ ] Add support for time zones
- [ ] Implement calendar view for date selection
- [ ] Add export/import of calculations
- [ ] Support for recurring event calculations
- [ ] Add multiple time zone display
- [ ] Implement workday calculations
- [ ] Add widget support
- [ ] Support for batch calculations

## 📊 Version History

- **1.0.0** (Current)
  - Initial release
  - Time difference calculator
  - Add/Subtract time operations
  - Material Design UI
  - Date and time pickers

---

**Made with ❤️ for all time calculation needs**
