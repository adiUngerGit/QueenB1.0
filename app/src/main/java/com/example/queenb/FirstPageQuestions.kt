package com.example.queenb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class FirstPageQuestions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page_questions)
    }

    fun nextPage(view: View) {
        val intent = Intent(this, Ex1::class.java)
        startActivity(intent)
    }
}


