package com.arash.altafi.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.arash.altafi.sharedpreferences.utils.SharedPreferencesName
import com.arash.altafi.sharedpreferences.utils.SharedPreferencesPhone
import com.google.android.material.button.MaterialButton

class SharedPrefencesWithClass : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtPhone: EditText
    private lateinit var btnClear: MaterialButton
    private lateinit var btnRemove: MaterialButton
    private lateinit var sharedPreferencesName : SharedPreferencesName
    private lateinit var sharedPreferencesPhone : SharedPreferencesPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_prefences_with_class)

        init()
    }

    private fun init() {
        bindViews()

        sharedPreferencesName = SharedPreferencesName()
        sharedPreferencesName.sharedPrefName(this)
        sharedPreferencesPhone = SharedPreferencesPhone()
        sharedPreferencesPhone.sharedPrefPhone(this)

        btnClear.setOnClickListener {
            sharedPreferencesPhone.clear()
            sharedPreferencesName.clear()
        }

        btnRemove.setOnClickListener {
            sharedPreferencesPhone.remove()
            sharedPreferencesName.remove()
        }
    }

    override fun onResume() {
        super.onResume()
        val myName : String ?= sharedPreferencesName.getName()
        val myPhone: Long = sharedPreferencesPhone.getPhone()
        edtName.setText(myName)
        edtPhone.setText(myPhone.toString())
    }

    override fun onPause() {
        super.onPause()
        sharedPreferencesName.saveName(edtName.text.toString())
        sharedPreferencesPhone.savePhone(edtPhone.text.toString().toLong())
    }

    override fun onDestroy() {
        super.onDestroy()
        sharedPreferencesName.saveName(edtName.text.toString())
        sharedPreferencesPhone.savePhone(edtPhone.text.toString().toLong())
    }

    private fun bindViews() {
        edtName = findViewById(R.id.edt_name_class)
        edtPhone = findViewById(R.id.edt_phone_class)
        btnRemove = findViewById(R.id.btn_remove_class)
        btnClear = findViewById(R.id.btn_clear_class)
    }

}