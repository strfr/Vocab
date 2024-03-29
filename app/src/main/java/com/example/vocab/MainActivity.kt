package com.example.vocab

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startLearningButton= findViewById<Button>(R.id.startLearningButton)
        var words = ArrayList<Words>()
        var dbHelper = DBHelper(this)
        Log.e("datasize", dbHelper.getDataSize().toString())

        if(dbHelper.getDataSize()<29){
        words =Constants.getWords()

        for (item in words){
            dbHelper.insertData(item)
        }}
        words = dbHelper.readData() as ArrayList<Words>
        var counter=0
        for (item in words) {
            if (item.isUserAdded == 1)
                counter++
            Log.e("dasd",counter.toString())
        }
        if (counter != 0) {
            startService(Intent(this, NotificationService::class.java))
        }
        startLearningButton.setOnClickListener{
            val startLearningIntent = Intent(this,StartLearningActivity::class.java)
            startActivity(startLearningIntent)

        }
        addWordButton.setOnClickListener{
            val addWordIntent = Intent(this,AddWordActivity::class.java)
            startActivity(addWordIntent)
        }
        makeQuizButton.setOnClickListener{
            val makeQuizIntent = Intent(this,QuizSelectActivity::class.java)
            startActivity(makeQuizIntent)
            finish()
        }

    }
}