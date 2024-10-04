package com.tasklay.data.utils

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun calculateDaysLeft(targetDate: String, dueDate: String?): Long {
    // Define the date format (assuming "yyyy-MM-dd")
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    return dueDate?.let {
        try {
            // Parse the targetDate and dueDate to Date objects
            val target = dateFormat.parse(targetDate)
            val due = dateFormat.parse(dueDate)

            val diffInMillis = due.time - target.time

            // Convert milliseconds to days
            TimeUnit.MILLISECONDS.toDays(diffInMillis)
        } catch (e: Exception) {
            // If parsing fails or there's an error, return a default value like -1
            -1
        }
    } ?: -1
}

