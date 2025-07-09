package com.example.calltracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Hour6 : AppCompatActivity() {

    private var callCount = 0
    private var surveyCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.Hour6)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCall = findViewById<Button>(R.id.button21)
        val btnSurvey = findViewById<Button>(R.id.button22)
        val btnDone = findViewById<Button>(R.id.button23)

        btnCall.setOnClickListener {
            callCount++
        }

        btnSurvey.setOnClickListener {
            surveyCount++
        }

        btnDone.setOnClickListener {
            val intent = Intent(this, ScoreActivity::class.java) //

            // Pass forward all previous hour data
            intent.putExtra("hour1_calls", getIntent().getIntExtra("hour1_calls", 0))
            intent.putExtra("hour1_surveys", getIntent().getIntExtra("hour1_surveys", 0))
            intent.putExtra("hour2_calls", getIntent().getIntExtra("hour2_calls", 0))
            intent.putExtra("hour2_surveys", getIntent().getIntExtra("hour2_surveys", 0))
            intent.putExtra("hour3_calls", getIntent().getIntExtra("hour3_calls", 0))
            intent.putExtra("hour3_surveys", getIntent().getIntExtra("hour3_surveys", 0))
            intent.putExtra("hour4_calls", getIntent().getIntExtra("hour4_calls", 0))
            intent.putExtra("hour4_surveys", getIntent().getIntExtra("hour4_surveys", 0))
            intent.putExtra("hour5_calls", getIntent().getIntExtra("hour5_calls", 0))
            intent.putExtra("hour5_surveys", getIntent().getIntExtra("hour5_surveys", 0))

            // Add Hour 6 data
            intent.putExtra("hour6_calls", callCount)
            intent.putExtra("hour6_surveys", surveyCount)

            startActivity(intent)
        }
    }
}
