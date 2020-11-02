package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

lateinit var doneButtonView: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doneButtonView = findViewById(R.id.done_button)
        doneButtonView.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(doneButtonView: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        // Change nicknameText to editText contents
        // Hide editText and doneButtonView
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        doneButtonView.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        nicknameTextView.isCursorVisible = false

        // Hide keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(doneButtonView.windowToken, 0)
    }
}