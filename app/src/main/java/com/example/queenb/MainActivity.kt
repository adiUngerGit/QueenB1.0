package com.example.queenb

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun FirstPageQuestions(view: View) {

        val intent = Intent(this, FirstPageQuestions::class.java)
        startActivity(intent)
    }
    fun fAQActivity(view: View) {

        val intent = Intent(this, FAQActivity::class.java)
        startActivity(intent)
    }
    fun contact_us(view: View) {

        val intent = Intent(this, contact_us::class.java)
        startActivity(intent)
    }


}
