package com.arash.altafi.sharedpreferences.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesPhone {

    private var preferences : SharedPreferences ?= null

    fun sharedPrefPhone(context : Context) {
        preferences = context.getSharedPreferences("my_phone_class", Context.MODE_PRIVATE)
    }

    fun savePhone(phone : Long) {
        val editor : SharedPreferences.Editor = preferences!!.edit()
        editor.putLong("phone_class", phone)
        editor.apply()
    }

    fun getPhone(): Long {
        return preferences!!.getLong("phone_class", 0)
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
        editor.remove("my_phone_class")
        editor.apply()
    }

}