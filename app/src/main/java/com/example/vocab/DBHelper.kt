package com.example.vocab

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

class DBHelper(val context: Context) :
    SQLiteOpenHelper(context, DBHelper.DATABASE_NAME, null, DBHelper.DATABASE_VERSION) {
    private val TABLE_NAME = "Word"
    private val COL_ID = "id"
    private val COL_WORD = "word"
    private val COL_TYPE = "type"
    private val COL_DEFINITION = "definition"
    private val COL_EXAMPLE_SENTENCE = "example_sentence"
    private val COL_SYNONYM_IS_EXISTS = "synonym_is_exists"
    private val COL_SYNONYM = "synonym"
    private val COL_ANTONYM_IS_EXISTS = "antonym_is_exists"
    private val COL_ANTONYM = "antonym"
    private val COL_USER_ADDED = "user_added"

    companion object {
        private val DATABASE_NAME = "SQLITE_DATABASE"//database adı
        private val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_WORD  VARCHAR(256),$COL_TYPE  VARCHAR(256), $COL_DEFINITION  VARCHAR(256), $COL_EXAMPLE_SENTENCE VARCHAR(256), $COL_SYNONYM_IS_EXISTS  INTEGER, $COL_SYNONYM  VARCHAR(256), $COL_ANTONYM_IS_EXISTS  INTEGER, $COL_ANTONYM  VARCHAR(256), $COL_USER_ADDED INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertData(words: Words) {
        val sqliteDB = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COL_WORD, words.word)
        contentValues.put(COL_TYPE, words.type)
        contentValues.put(COL_DEFINITION, words.definition)
        contentValues.put(COL_EXAMPLE_SENTENCE, words.example_sentence)
        contentValues.put(COL_SYNONYM_IS_EXISTS, words.isSynonymExists)
        contentValues.put(COL_SYNONYM, words.Synonym)
        contentValues.put(COL_ANTONYM_IS_EXISTS, words.isAntonymExists)
        contentValues.put(COL_ANTONYM, words.Antonym)
        contentValues.put(COL_USER_ADDED, words.isUserAdded)
        val result = sqliteDB.insertWithOnConflict(
            TABLE_NAME,
            null,
            contentValues,
            SQLiteDatabase.CONFLICT_IGNORE
        )
    }

    fun readData(): MutableList<Words> {
        val wordList = mutableListOf<Words>()
        val sqliteDB = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = sqliteDB.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                var words = Words(
                    result.getString(result.getColumnIndex(COL_ID)).toInt(),
                    result.getString(result.getColumnIndex(COL_WORD)),
                    result.getString(result.getColumnIndex(COL_TYPE)),
                    result.getString(result.getColumnIndex(COL_DEFINITION)),
                    result.getString(result.getColumnIndex(COL_EXAMPLE_SENTENCE)),
                    result.getInt(result.getColumnIndex(COL_SYNONYM_IS_EXISTS)),
                    result.getString(result.getColumnIndex(COL_SYNONYM)),
                    result.getInt(result.getColumnIndex(COL_ANTONYM_IS_EXISTS)),
                    result.getString(result.getColumnIndex(COL_ANTONYM)),
                    result.getInt(result.getColumnIndex(COL_USER_ADDED)),
                )


                wordList.add(words)
            } while (result.moveToNext())
        }
        result.close()
        sqliteDB.close()
        return wordList
    }

    fun getDataSize(): Int {
        val sqliteDB = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = sqliteDB.rawQuery(query, null)
        var counter = 0
        if (result.moveToFirst()) {
            do {
                counter++
            } while (result.moveToNext())
        }
        result.close()
        sqliteDB.close()
        return counter
    }

    fun deleteAllData() {
        val sqliteDB = this.writableDatabase
        sqliteDB.delete(TABLE_NAME, null, null)
        sqliteDB.close()

    }

}