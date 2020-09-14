package com.example.queenb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Ex2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex2)
        var editText = findViewById<EditText>(R.id.code)
        editText.setText("<h1 style='color:red'> הטקסט שלך </h1>")
    }
    fun finish(view: View) {
        //loud web view
        var webView = findViewById<WebView>(R.id.webView)
        var HTMLtest =  findViewById<EditText>(R.id.code).text.toString()
        webView.loadDataWithBaseURL(null,HTMLtest,"text/html","utf-8",null)
        //close the keyboard
        val inputManager:InputMethodManager =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)
    }

    fun nextPage(v: View?) {
        val intent = Intent(this, Ex3::class.java)
        startActivity(intent)
    }
}

