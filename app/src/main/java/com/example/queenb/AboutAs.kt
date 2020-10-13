package com.example.queenb

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AboutAs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_as)
    }

    fun goHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    fun enterSign(view: View) {
        val url = "https://www.queenb.org.il/signup"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }
}