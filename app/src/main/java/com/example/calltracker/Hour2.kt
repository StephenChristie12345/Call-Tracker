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
        val btnDone = findViewById<Button>(R.id.button8)

        btnCall.setOnClickListener { callCount++ }
        btnSurvey.setOnClickListener { surveyCount++ }

        btnNext.setOnClickListener {
            val incoming = intent
            val nextIntent = Intent(this, Hour3::class.java)
            nextIntent.putExtra("hour1_calls", incoming.getIntExtra("hour1_calls", 0))
            nextIntent.putExtra("hour1_surveys", incoming.getIntExtra("hour1_surveys", 0))
            nextIntent.putExtra("hour2_calls", callCount)
            nextIntent.putExtra("hour2_surveys", surveyCount)
            startActivity(nextIntent)
        }

        btnDone.setOnClickListener {
            val incoming = intent
            val nextIntent = Intent(this, ActivityScore::class.java)
            nextIntent.putExtra("hour1_calls", incoming.getIntExtra("hour1_calls", 0))
            nextIntent.putExtra("hour1_surveys", incoming.getIntExtra("hour1_surveys", 0))
            nextIntent.putExtra("hour2_calls", callCount)
            nextIntent.putExtra("hour2_surveys", surveyCount)
            nextIntent.putExtra("hour3_calls", 0)
            nextIntent.putExtra("hour3_surveys", 0)
            nextIntent.putExtra("hour4_calls", 0)
            nextIntent.putExtra("hour4_surveys", 0)
            nextIntent.putExtra("hour5_calls", 0)
            nextIntent.putExtra("hour5_surveys", 0)
            nextIntent.putExtra("hour6_calls", 0)
            nextIntent.putExtra("hour6_surveys", 0)
            startActivity(nextIntent)
        }
    }
}
