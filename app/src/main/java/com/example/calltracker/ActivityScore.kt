package com.example.calltracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityScore : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Get data from all hours
        val hour1Calls = intent.getIntExtra("hour1_calls", 0)
        val hour1Surveys = intent.getIntExtra("hour1_surveys", 0)
        val hour2Calls = intent.getIntExtra("hour2_calls", 0)
        val hour2Surveys = intent.getIntExtra("hour2_surveys", 0)
        val hour3Calls = intent.getIntExtra("hour3_calls", 0)
        val hour3Surveys = intent.getIntExtra("hour3_surveys", 0)
        val hour4Calls = intent.getIntExtra("hour4_calls", 0)
        val hour4Surveys = intent.getIntExtra("hour4_surveys", 0)
        val hour5Calls = intent.getIntExtra("hour5_calls", 0)
        val hour5Surveys = intent.getIntExtra("hour5_surveys", 0)
        val hour6Calls = intent.getIntExtra("hour6_calls", 0)
        val hour6Surveys = intent.getIntExtra("hour6_surveys", 0)

        // Calculate totals
        val totalCalls = hour1Calls + hour2Calls + hour3Calls + hour4Calls + hour5Calls + hour6Calls
        val totalSurveys = hour1Surveys + hour2Surveys + hour3Surveys + hour4Surveys + hour5Surveys + hour6Surveys

        // Format summary
        val summary = """
            Hour 1: 
            $hour1Calls Calls, $hour1Surveys Surveys
            Hour 2:
            $hour2Calls Calls, $hour2Surveys Surveys
            Hour 3:
            $hour3Calls Calls, $hour3Surveys Surveys
            Hour 4: 
            $hour4Calls Calls, $hour4Surveys Surveys
            Hour 5: 
            $hour5Calls Calls, $hour5Surveys Surveys
            Hour 6: 
            $hour6Calls Calls, $hour6Surveys Surveys
            
            ------------------------------
            Total: $totalCalls Calls, $totalSurveys Surveys
        """.trimIndent()

        // Display summary
        val scoreTextView = findViewById<TextView>(R.id.textView9)
        scoreTextView.text = summary

    }
}

