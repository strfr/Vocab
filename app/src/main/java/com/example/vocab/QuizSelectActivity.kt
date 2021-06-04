package com.example.vocab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_quiz_select.*


class QuizSelectActivity : AppCompatActivity() {
    var selected =""
    override fun onCreate(savedInstanceState: Bundle?) {
        val types = resources.getStringArray(R.array.types_array)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_select)
        val spinner: Spinner = findViewById(R.id.spinner)
// Create an ArrayAdapter using the string array and a default spinner layout
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, types)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
               selected= types[position]
                Log.e("sd",selected)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
        btn_start_quiz.setOnClickListener{
            val intent = Intent(baseContext, QuizQuestionsActivity::class.java)
            intent.putExtra("selected_item", selected)
            startActivity(intent)
        }
    }

}