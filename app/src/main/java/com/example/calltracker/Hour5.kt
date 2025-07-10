package com.example.calltracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Hour5 : AppCompatActivity() {

    // Variables to track the number of calls and surveys
    private var callCount = 0
    private var surveyCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hour5) // Make sure this layout file exists// Make sure this layout file exists

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Connect UI buttons to their IDs in the XML layout
        val btnCall = findViewById<Button>(R.id.button17) // Call button
        val btnSurvey = findViewById<Button>(R.id.button18) // Survey button
        val btnNext = findViewById<Button>(R.id.button19) // Next button

        // Increase call count when Call button is clicked
        btnCall.setOnClickListener {
            callCount++
        }

        // Increase survey count when Survey button is clicked
        btnSurvey.setOnClickListener {
            surveyCount++
        }
        btnNext.setOnClickListener {
            val intent = Intent(this, Hour6::class.java)

            // Pass all previous hour data from incomingIntent to nextIntent
            nextIntent.putExtra("hour1_calls", incomingIntent.getIntExtra("hour1_calls", 0))
            nextIntent.putExtra("hour1_surveys", incomingIntent.getIntExtra("hour1_surveys", 0))
            nextIntent.putExtra("hour2_calls", incomingIntent.getIntExtra("hour2_calls", 0))
            nextIntent.putExtra("hour2_surveys", incomingIntent.getIntExtra("hour2_surveys", 0))
            nextIntent.putExtra("hour3_calls", incomingIntent.getIntExtra("hour3_calls", 0))
            nextIntent.putExtra("hour3_surveys", incomingIntent.getIntExtra("hour3_surveys", 0))
            nextIntent.putExtra("hour4_calls", incomingIntent.getIntExtra("hour4_calls", 0))
            nextIntent.putExtra("hour4_surveys", incomingIntent.getIntExtra("hour4_surveys", 0))

            // Add Hour 5 data
            nextIntent.putExtra("hour5_calls", callCount)
            nextIntent.putExtra("hour5_surveys", surveyCount)

            // Start the Hour6 activity
            startActivity(nextIntent)
        }
    }
}
