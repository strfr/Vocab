package com.example.vocab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_start_learning.*

class StartLearningActivity : AppCompatActivity() {
    var words = ArrayList<Words>()
    var randomNumber = 0
    private fun init() {
        dbHelper = DBHelper(this)

        words = dbHelper.readData() as ArrayList<Words>
    }

    var dbHelper = DBHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_learning)
        init()
        makeWordCard()
        btn_next_word.setOnClickListener {
            makeWordCard()
        }
        btn_add_to_my_words.setOnClickListener {
            Log.e("asdss", randomNumber.toString())
            dbHelper.deleteAllData()
            words[randomNumber].isUserAdded = 1
            for (item in words) {
                dbHelper.insertData(item)
            }
        }
    }

    private fun makeWordCard() {
        randomNumber = (0..20).random() // generated random from 0 to 10 included
        if (words[randomNumber].isUserAdded == 0) {
            val tvWord = findViewById<TextView>(R.id.tv_word)
            tvWord.text = words[randomNumber].word
            val tvType = findViewById<TextView>(R.id.tv_type_text)
            tvType.text = words[randomNumber].type
            val tvDefinition = findViewById<TextView>(R.id.tv_definition_text)
            tvDefinition.text = words[randomNumber].definition
            val tvExample = findViewById<TextView>(R.id.tv_example_text)
            tvExample.text = words[randomNumber].example_sentence
            val tvSynonymLabel = findViewById<TextView>(R.id.tv_synonym_label)
            val tvSynonymText = findViewById<TextView>(R.id.tv_synonym_text)
            if (words[randomNumber].isSynonymExists == 1) {
                tvSynonymLabel.text = getString(R.string.sow)
                tvSynonymText.text = words[randomNumber].Synonym
            } else {
                tvSynonymLabel.text = ""
                tvSynonymText.text = ""
            }
            val tvAntonymLabel = findViewById<TextView>(R.id.tv_antonym_label)
            val tvAntonymText = findViewById<TextView>(R.id.tv_antonym_text)
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

