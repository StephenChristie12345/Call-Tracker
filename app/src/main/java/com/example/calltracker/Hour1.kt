package com.example.calltracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Hour1 : AppCompatActivity() {

    private var callCount = 0
    private var surveyCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hour1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCall = findViewById<Button>(R.id.button)
        val btnSurvey = findViewById<Button>(R.id.button2)
        val btnNext = findViewById<Button>(R.id.button3)

        btnCall.setOnClickListener {
            callCount++
        }

        btnSurvey.setOnClickListener {
            surveyCount++
        }

        btnNext.setOnClickListener {
            val intent = Intent(this, Hour2::class.java)
            intent.putExtra("hour1_calls", callCount)
            intent.putExtra("hour1_surveys", surveyCount)
            startActivity(intent)
        }
    }
}



