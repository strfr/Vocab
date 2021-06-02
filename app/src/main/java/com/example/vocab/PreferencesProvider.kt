package com.example.vocab

import android.content.Context
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


object PreferencesProvider {
//private val sharedPreferences = context.getSharedPreferences("myPreferences",0)
//    fun putString(key: String, value:String){
//        return sharedPreferences.edit().
//    }
private val LIST_KEY: String? = "list_key100"

        fun writeListInPref(context: Context?, list: ArrayList<Words?>?) {
        val gson = Gson()
        val jsonString: String = gson.toJson(list)
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = pref.edit()
        editor.putString(LIST_KEY, jsonString)
        editor.apply()
    }

    fun readListFromPref(context: Context?): ArrayList<Words?>? {
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val jsonString = pref.getString(LIST_KEY, "")
        val gson = Gson()
        val type: Type = object : TypeToken<ArrayList<Words?>?>() {}.type
        return gson.fromJson(jsonString, type)
    }
}