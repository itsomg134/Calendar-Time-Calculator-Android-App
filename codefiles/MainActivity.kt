package com.example.calendartimecalculator

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var datePickerFrom: TextInputEditText
    private lateinit var timePickerFrom: TextInputEditText
    private lateinit var datePickerTo: TextInputEditText
    private lateinit var timePickerTo: TextInputEditText
    private lateinit var calculateButton: MaterialButton
    private lateinit var resultTextView: TextView
    private lateinit var resultContainer: LinearLayout
    private lateinit var fromLayout: TextInputLayout
    private lateinit var toLayout: TextInputLayout
    
    private lateinit var operationSpinner: Spinner
    private lateinit var datePickerOperand: TextInputEditText
    private lateinit var timePickerOperand: TextInputEditText
    private lateinit var addSubtractButton: MaterialButton
    private lateinit var operationResultTextView: TextView
    private lateinit var operationResultContainer: LinearLayout
    
    private lateinit var clearButton: MaterialButton

    private val calendarFrom = Calendar.getInstance()
    private val calendarTo = Calendar.getInstance()
    private val calendarOperand = Calendar.getInstance()
    
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    private val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        initViews()
        setupDatePickers()
        setupTimePickers()
        setupCalculateButton()
        setupAddSubtractButton()
        setupClearButton()
        setupSpinner()
        
        // Set default values
        setDefaultDateTime()
    }

    private fun initViews() {
        datePickerFrom = findViewById(R.id.datePickerFrom)
        timePickerFrom = findViewById(R.id.timePickerFrom)
        datePickerTo = findViewById(R.id.datePickerTo)
        timePickerTo = findViewById(R.id.timePickerTo)
        calculateButton = findViewById(R.id.calculateButton)
        resultTextView = findViewById(R.id.resultTextView)
        resultContainer = findViewById(R.id.resultContainer)
        fromLayout = findViewById(R.id.fromLayout)
        toLayout = findViewById(R.id.toLayout)
        
        operationSpinner = findViewById(R.id.operationSpinner)
        datePickerOperand = findViewById(R.id.datePickerOperand)
        timePickerOperand = findViewById(R.id.timePickerOperand)
        addSubtractButton = findViewById(R.id.addSubtractButton)
        operationResultTextView = findViewById(R.id.operationResultTextView)
        operationResultContainer = findViewById(R.id.operationResultContainer)
        
        clearButton = findViewById(R.id.clearButton)
    }

    private fun setupSpinner() {
        val operations = arrayOf("Add Time", "Subtract Time")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operations)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        operationSpinner.adapter = adapter
    }

    private fun setDefaultDateTime() {
        val currentDateTime = Calendar.getInstance()
        datePickerFrom.setText(dateFormat.format(currentDateTime.time))
        timePickerFrom.setText(timeFormat.format(currentDateTime.time))
        datePickerTo.setText(dateFormat.format(currentDateTime.time))
        timePickerTo.setText(timeFormat.format(currentDateTime.time))
        datePickerOperand.setText(dateFormat.format(currentDateTime.time))
        timePickerOperand.setText(timeFormat.format(currentDateTime.time))
    }

    private fun setupDatePickers() {
        datePickerFrom.setOnClickListener { showDatePicker(datePickerFrom, calendarFrom) }
        datePickerTo.setOnClickListener { showDatePicker(datePickerTo, calendarTo) }
        datePickerOperand.setOnClickListener { showDatePicker(datePickerOperand, calendarOperand) }
        
        // Also allow manual input but validate
        datePickerFrom.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) validateDate(datePickerFrom)
        }
        datePickerTo.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) validateDate(datePickerTo)
        }
        datePickerOperand.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) validateDate(datePickerOperand)
        }
    }

    private fun validateDate(editText: TextInputEditText) {
        val text = editText.text.toString()
        if (text.isNotEmpty()) {
            try {
                dateFormat.parse(text)
            } catch (e: Exception) {
                Toast.makeText(this, "Invalid date format. Use DD/MM/YYYY", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDatePicker(editText: TextInputEditText, calendar: Calendar) {
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                calendar.set(year, month, dayOfMonth)
                editText.setText(dateFormat.format(calendar.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun setupTimePickers() {
        timePickerFrom.setOnClickListener { showTimePicker(timePickerFrom, calendarFrom) }
        timePickerTo.setOnClickListener { showTimePicker(timePickerTo, calendarTo) }
        timePickerOperand.setOnClickListener { showTimePicker(timePickerOperand, calendarOperand) }
    }

    private fun showTimePicker(editText: TextInputEditText, calendar: Calendar) {
        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                calendar.set(Calendar.MINUTE, minute)
                editText.setText(timeFormat.format(calendar.time))
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            true
        )
        timePickerDialog.show()
    }

    private fun setupCalculateButton() {
        calculateButton.setOnClickListener {
            val dateFromStr = datePickerFrom.text.toString()
            val timeFromStr = timePickerFrom.text.toString()
            val dateToStr = datePickerTo.text.toString()
            val timeToStr = timePickerTo.text.toString()
            
            if (validateInputs(dateFromStr, timeFromStr, dateToStr, timeToStr)) {
                calculateDifference(dateFromStr, timeFromStr, dateToStr, timeToStr)
            }
        }
    }

    private fun validateInputs(
        dateFromStr: String,
        timeFromStr: String,
        dateToStr: String,
        timeToStr: String
    ): Boolean {
        if (TextUtils.isEmpty(dateFromStr) || TextUtils.isEmpty(timeFromStr) ||
            TextUtils.isEmpty(dateToStr) || TextUtils.isEmpty(timeToStr)) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun calculateDifference(
        dateFromStr: String,
        timeFromStr: String,
        dateToStr: String,
        timeToStr: String
    ) {
        try {
            val fromDate = dateFormat.parse(dateFromStr) ?: return
            val fromTime = timeFormat.parse(timeFromStr) ?: return
            val toDate = dateFormat.parse(dateToStr) ?: return
            val toTime = timeFormat.parse(timeToStr) ?: return

            val calendarFromCombined = Calendar.getInstance().apply {
                time = fromDate
                val timeCal = Calendar.getInstance().apply { time = fromTime }
                set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY))
                set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE))
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }

            val calendarToCombined = Calendar.getInstance().apply {
                time = toDate
                val timeCal = Calendar.getInstance().apply { time = toTime }
                set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY))
                set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE))
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }

            val diffInMillis = calendarToCombined.timeInMillis - calendarFromCombined.timeInMillis
            
            if (diffInMillis < 0) {
                resultTextView.text = "Error: 'To' date/time must be later than 'From' date/time"
                resultContainer.isVisible = true
                return
            }

            val diffInSeconds = diffInMillis / 1000
            val days = diffInSeconds / (24 * 60 * 60)
            val hours = (diffInSeconds % (24 * 60 * 60)) / (60 * 60)
            val minutes = (diffInSeconds % (60 * 60)) / 60
            val seconds = diffInSeconds % 60

            val result = buildString {
                append("📅 Time Difference\n\n")
                append("From: $dateFromStr $timeFromStr\n")
                append("To: $dateToStr $timeToStr\n\n")
                append("═══════════════════\n")
                
                if (days > 0) append("📆 $days day${if (days > 1) "s" else ""}\n")
                if (hours > 0) append("🕐 $hours hour${if (hours > 1) "s" else ""}\n")
                if (minutes > 0) append("⏱️ $minutes minute${if (minutes > 1) "s" else ""}\n")
                if (seconds > 0) append("⏲️ $seconds second${if (seconds > 1) "s" else ""}\n")
                if (days == 0L && hours == 0L && minutes == 0L && seconds == 0L) {
                    append("⏰ Same time!")
                }
                
                append("\n═══════════════════\n")
                append("Total: ${formatDuration(diffInSeconds)}")
            }
            
            resultTextView.text = result
            resultContainer.isVisible = true
            
        } catch (e: Exception) {
            Toast.makeText(this, "Error parsing dates: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun formatDuration(totalSeconds: Long): String {
        val days = totalSeconds / (24 * 60 * 60)
        val hours = (totalSeconds % (24 * 60 * 60)) / (60 * 60)
        val minutes = (totalSeconds % (60 * 60)) / 60
        val seconds = totalSeconds % 60
        
        return buildString {
            if (days > 0) append("${days}d ")
            append("${hours}h ${minutes}m ${seconds}s")
        }
    }

    private fun setupAddSubtractButton() {
        addSubtractButton.setOnClickListener {
            val dateStr = datePickerOperand.text.toString()
            val timeStr = timePickerOperand.text.toString()
            val operation = operationSpinner.selectedItem.toString()
            
            if (TextUtils.isEmpty(dateStr) || TextUtils.isEmpty(timeStr)) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            performDateTimeOperation(dateStr, timeStr, operation)
        }
    }

    private fun performDateTimeOperation(dateStr: String, timeStr: String, operation: String) {
        try {
            val date = dateFormat.parse(dateStr) ?: return
            val time = timeFormat.parse(timeStr) ?: return
            
            val calendar = Calendar.getInstance().apply {
                this.time = date
                val timeCal = Calendar.getInstance().apply { this.time = time }
                set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY))
                set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE))
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }
            
            // Show dialog to get amount to add/subtract
            showAmountDialog(calendar, operation)
            
        } catch (e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun showAmountDialog(calendar: Calendar, operation: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_amount, null)
        val daysInput = dialogView.findViewById<TextInputEditText>(R.id.daysInput)
        val hoursInput = dialogView.findViewById<TextInputEditText>(R.id.hoursInput)
        val minutesInput = dialogView.findViewById<TextInputEditText>(R.id.minutesInput)
        val addButton = dialogView.findViewById<MaterialButton>(R.id.confirmAddButton)
        val cancelButton = dialogView.findViewById<MaterialButton>(R.id.cancelAddButton)
        
        val dialog = android.app.AlertDialog.Builder(this)
            .setTitle("${operation.substringBefore(" ")} Time")
            .setView(dialogView)
            .setCancelable(false)
            .create()
        
        addButton.setOnClickListener {
            val days = daysInput.text.toString().toLongOrNull() ?: 0
            val hours = hoursInput.text.toString().toLongOrNull() ?: 0
            val minutes = minutesInput.text.toString().toLongOrNull() ?: 0
            
            if (days == 0L && hours == 0L && minutes == 0L) {
                Toast.makeText(this, "Please enter at least one value", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            val resultCalendar = calendar.clone() as Calendar
            
            when (operation) {
                "Add Time" -> {
                    resultCalendar.add(Calendar.DAY_OF_YEAR, days.toInt())
                    resultCalendar.add(Calendar.HOUR_OF_DAY, hours.toInt())
                    resultCalendar.add(Calendar.MINUTE, minutes.toInt())
                }
                "Subtract Time" -> {
                    resultCalendar.add(Calendar.DAY_OF_YEAR, -days.toInt())
                    resultCalendar.add(Calendar.HOUR_OF_DAY, -hours.toInt())
                    resultCalendar.add(Calendar.MINUTE, -minutes.toInt())
                }
            }
            
            val resultDate = dateFormat.format(resultCalendar.time)
            val resultTime = timeFormat.format(resultCalendar.time)
            
            val result = buildString {
                append("✅ Operation Result\n\n")
                append("Original: ${dateFormat.format(calendar.time)} ${timeFormat.format(calendar.time)}\n")
                append("Operation: $operation\n")
                append("Amount: ${formatAmount(days, hours, minutes)}\n\n")
                append("═══════════════════\n")
                append("📅 Result: $resultDate\n")
                append("🕐 Time: $resultTime\n")
                append("═══════════════════\n")
            }
            
            operationResultTextView.text = result
            operationResultContainer.isVisible = true
            dialog.dismiss()
        }
        
        cancelButton.setOnClickListener {
            dialog.dismiss()
        }
        
        dialog.show()
    }

    private fun formatAmount(days: Long, hours: Long, minutes: Long): String {
        return buildString {
            if (days > 0) append("${days}d ")
            if (hours > 0) append("${hours}h ")
            if (minutes > 0) append("${minutes}m")
            if (isEmpty()) append("0")
        }
    }

    private fun setupClearButton() {
        clearButton.setOnClickListener {
            resultContainer.isVisible = false
            operationResultContainer.isVisible = false
            resultTextView.text = ""
            operationResultTextView.text = ""
            setDefaultDateTime()
        }
    }
}