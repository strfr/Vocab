package com.example.vocab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_word.*

class AddWordActivity : AppCompatActivity() {
    private val LIST_KEY: String? = "list_key100"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)
        var words = PreferencesProvider.readListFromPref(this)
        add_word_ac_btn.setOnClickListener {
            if (words != null) {
                words.add(Words(et_word.text.toString(),et_type.text.toString(),et_definition.text.toString(),et_example_sentence.text.toString(),cb_is_synonym_exists.isChecked,
                    et_synonym.text.toString(),cb_is_antonym_exists.isChecked,et_antonym.text.toString()))
                Toast.makeText(this,"Word added",Toast.LENGTH_LONG).show()
                val mainIntent = Intent(this,MainActivity::class.java)
                startActivity(mainIntent)
            }
            PreferencesProvider.writeListInPref(this,words)


        }
    }
}