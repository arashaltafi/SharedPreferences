package com.arash.altafi.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class SharedPrefences : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtPhone: EditText

    private val login = "MY_TEXT"
    private val name = "myStoredName"
    private val phone = "myStoredPhone"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_prefences)

        bindViews()
    }

    private fun bindViews() {
        edtName = findViewById(R.id.edt_name)
        edtPhone = findViewById(R.id.edt_phone)
    }

    override fun onResume() {
        super.onResume()
        var sharedPref: SharedPreferences = getSharedPreferences(login, MODE_PRIVATE)
        val myName : String ?= sharedPref.getString(name, null)
        val myPhone : Long = sharedPref.getLong(phone,0)
        edtName.setText(myName)
        edtPhone.setText(myPhone.toString())
    }

    override fun onPause() {
        super.onPause()
        var sharedPref: SharedPreferences = getSharedPreferences(login, MODE_PRIVATE)
        var edit = sharedPref.edit()
        edit.putString(name, edtName.text.toString())
        edit.putLong(phone, edtPhone.text.toString().toLong())
        edit.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        var sharedPref: SharedPreferences = getSharedPreferences(login, MODE_PRIVATE)
        var edit = sharedPref.edit()
        edit.putString(name, edtName.text.toString())
        edit.putLong(phone, edtPhone.text.toString().toLong())
        edit.apply()
    }

}