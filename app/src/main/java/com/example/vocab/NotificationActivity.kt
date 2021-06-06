package com.example.vocab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_notification.*
import java.util.concurrent.ExecutionException

class NotificationActivity : AppCompatActivity() {
    var words = ArrayList<Words>()
    var randomNumber = 0
    var dbHelper = DBHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        words = dbHelper.readData() as ArrayList<Words>
        Log.e("size", words.size.toString())
        makeWordCard()

        btn_memorized.setOnClickListener {
            dbHelper.deleteAllData()
            words[randomNumber].isUserAdded = 0
            for (item in words) {
                dbHelper.insertData(item)
            }
            makeWordCard()
        }
        btn_remind.setOnClickListener {
            makeWordCard()
        }
    }

    private fun makeWordCard() {
        words = dbHelper.readData() as ArrayList<Words>
//        while(words[randomNumber].isUserAdded!=1)
//            randomNumber = (0..30).random()
        // generated random from 0 to 10 included
        var counter = 0
        for (item in words) {
            if (item.isUserAdded == 1)
                counter++
        }
        if (counter == 0) {
            Toast.makeText(this, "No more words!", Toast.LENGTH_LONG).show()
            finish()
        } else {
            randomNumber = (0 until words.size).random()
            if (words[randomNumber].isUserAdded == 1) {
                val tvWord = findViewById<TextView>(R.id.tv_word_quiz)
                tvWord.text = words[randomNumber].word
                val tvType = findViewById<TextView>(R.id.tv_type_text_quiz)
                tvType.text = words[randomNumber].type
                val tvDefinition = findViewById<TextView>(R.id.tv_definition_text_quiz)
                tvDefinition.text = words[randomNumber].definition
                val tvExample = findViewById<TextView>(R.id.tv_example_text_quiz)
                tvExample.text = words[randomNumber].example_sentence
                val tvSynonymLabel = findViewById<TextView>(R.id.tv_synonym_label_quiz)
                val tvSynonymText = findViewById<TextView>(R.id.tv_synonym_text_quiz)
                if (words[randomNumber].isSynonymExists == 1) {
                    tvSynonymLabel.text = getString(R.string.sow)
                    tvSynonymText.text = words[randomNumber].Synonym
                } else {
                    tvSynonymLabel.text = ""
                    tvSynonymText.text = ""
                }
                val tvAntonymLabel = findViewById<TextView>(R.id.tv_antonym_label_quiz)
                val tvAntonymText = findViewById<TextView>(R.id.tv_antonym_text_quiz)
                if (words[randomNumber].isAntonymExists == 1) {
                    tvAntonymLabel.text = getString(R.string.aow)
                    tvAntonymText.text = words[randomNumber].Antonym
                } else {
                    tvAntonymLabel.text = ""
                    tvAntonymText.text = ""
                }
            } else
                makeWordCard()
        }


    }
}