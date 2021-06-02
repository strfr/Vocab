package com.example.vocab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.vocab.Constants
import com.example.vocab.MainActivity
import com.example.vocab.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        val totalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        tv_score.text = "Your score is $correctAnswers out of $totalQuestions"
        btn_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            finish()
        }


    }
}
