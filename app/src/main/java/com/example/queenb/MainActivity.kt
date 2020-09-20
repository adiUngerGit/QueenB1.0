package com.example.queenb

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
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
fun ambassadors(view: View) {

    val intent = Intent(this, ambassadors::class.java)
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

    fun our_projects(view: View) {

        val intent = Intent(this, our_projects::class.java)
        startActivity(intent)
    }

    fun enterInstegram(view: View) {
        val url = "https://www.instagram.com/queenbprogram/"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }


    fun enterFacebook(view: View) {
        val url = "https://www.facebook.com/queenb.program"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)

    }


}
