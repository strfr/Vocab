package com.example.vocab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_word.*

class AddWordActivity : AppCompatActivity() {
    private val LIST_KEY: String? = "list_key100"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)

        add_word_ac_btn.setOnClickListener {
                var antonymExists = 0
                if (cb_is_antonym_exists.isChecked)
                    antonymExists = 1
                else
                    antonymExists = 0
                var synonymExists = 0
                if (cb_is_synonym_exists.isChecked)
                    synonymExists = 1
                else
                    synonymExists = 0
            val dbHelper = DBHelper(this)
                    Log.e("aaaa","dasd")
                    dbHelper.insertData(
                    Words(
                        0,
                        et_word.text.toString(),
                        et_type.text.toString(),
                        et_definition.text.toString(),
                        et_example_sentence.text.toString(),
                        synonymExists,
                        et_synonym.text.toString(),
                        antonymExists,
                        et_antonym.text.toString(),
                        1
                    ))

                Toast.makeText(this, "Word added", Toast.LENGTH_LONG).show()



           finish()
        }
    }
}