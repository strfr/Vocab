package com.example.vocab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startLearningButton= findViewById<Button>(R.id.startLearningButton)
        startLearningButton.setOnClickListener{
            val startLearningIntent = Intent(this,StartLearningActivity::class.java)
            startActivity(startLearningIntent)

        }
        addWordButton.setOnClickListener{
            val addWordIntent = Intent(this,AddWordActivity::class.java)
            startActivity(addWordIntent)
        }
        makeQuizButton.setOnClickListener{
            val makeQuizIntent = Intent(this,QuizQuestionsActivity::class.java)
            startActivity(makeQuizIntent)
            finish()
        }
    }
}