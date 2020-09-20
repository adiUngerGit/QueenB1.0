package com.example.queenb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Ex4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex4)
    }

    //next page
    fun nextPage(v: View?) {
        val intent = Intent(this, Ex4B::class.java)
        startActivity(intent)
    }

    fun backHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}