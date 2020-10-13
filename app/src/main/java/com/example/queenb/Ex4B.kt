package com.example.queenb

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast

class Ex4B : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex4_b)
    }

    fun finish(view: View) {
        val inputManager: InputMethodManager =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)
        var answer =  findViewById<EditText>(R.id.answer)
        if (answer.text.toString() == "Queen") {
            Toast.makeText(this, "מעולה! איזה מלכה את!", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "לא נורא.. נסי שוב...", Toast.LENGTH_SHORT).show()
        }
    }

    fun nextPage(v: View?) {
        val intent = Intent(this, Finall::class.java)
        startActivity(intent)
    }


    fun backHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}