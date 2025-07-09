package com.example.calltracker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnRestart = findViewById<Button>(R.id.btnRestart)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val txtSummary = findViewById<TextView>(R.id.txtSummary)

        btnRestart.setOnClickListener {
            val intent = Intent(this, Hour1::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        btnExit.setOnClickListener {
            finishAffinity() // closes all activities and exits app
        }

        val summary = StringBuilder()
        for (i in 1..6) {
            val calls = intent.getIntExtra("hour${i}_calls", 0)
            val surveys = intent.getIntExtra("hour${i}_surveys", 0)
            summary.append("Hour $i: $calls calls, $surveys surveys\n")
        }

        txtSummary.text = summary.toString()
    }
}
