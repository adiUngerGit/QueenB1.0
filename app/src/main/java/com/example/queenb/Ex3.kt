package com.example.queenb

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.widget.EditText

class Ex3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex3)
        var editText = findViewById<EditText>(R.id.code)
        editText.setText("<body style=\"background-color:red;\">")
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

    //next page
    fun nextPage(v: View?) {
        val intent = Intent(this, FinalHTML::class.java)
        startActivity(intent)
    }

    fun backHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}