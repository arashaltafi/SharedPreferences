package com.arash.altafi.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnShared : MaterialButton
    private lateinit var btnSharedClass : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        bindViews()

        btnShared.setOnClickListener {
            startActivity(Intent(this , SharedPrefences::class.java))
        }

        btnSharedClass.setOnClickListener {
            startActivity(Intent(this , SharedPrefencesWithClass::class.java))
        }
    }

    private fun bindViews() {
        btnShared = findViewById(R.id.btn_shared)
        btnSharedClass = findViewById(R.id.btn_shared_class)
    }

}