package com.arash.altafi.sharedpreferences.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesName {

    private var preferences : SharedPreferences ?= null

    fun sharedPrefName(context : Context) {
        preferences = context.getSharedPreferences("my_name_class", Context.MODE_PRIVATE)
    }

    fun saveName(name : String?) {
        val editor : SharedPreferences.Editor = preferences!!.edit()
        editor.putString("name_class", name)
        editor.apply()
    }

    fun getName(): String? {
        return preferences!!.getString("name_class", null)
    }

    fun clear()
    {
        val editor:SharedPreferences.Editor = preferences!!.edit()
        editor.clear()
        editor.apply()
    }

    fun remove()
    {
        val editor:SharedPreferences.Editor = preferences!!.edit()
        editor.remove("name_class")
        editor.apply()
    }

}