package com.example.calltracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Hour2 : AppCompatActivity() {

    private var callCount = 0
    private var surveyCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hour2)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCall = findViewById<Button>(R.id.button5)
        val btnSurvey = findViewById<Button>(R.id.button6)
        val btnNext = findViewById<Button>(R.id.button7)

        btnCall.setOnClickListener {
            callCount++
        }

        btnSurvey.setOnClickListener {
            surveyCount++
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, Hour3::class.java)

            // Pass forward Hour 1 data
            intent.putExtra("hour1_calls", intent.getIntExtra("hour1_calls", 0))
            intent.putExtra("hour1_surveys", intent.getIntExtra("hour1_surveys", 0))

            // Add Hour 2 data
            intent.putExtra("hour2_calls", callCount)
            intent.putExtra("hour2_surveys", surveyCount)

            startActivity(intent)
        }
    }
}
