package com.example.queenb

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.HorizontalScrollView
import android.widget.RatingBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    lateinit var editTextName: EditText
    lateinit var ratingBar: RatingBar
    lateinit var buttonSave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //scrolling animation
       /* var viewPager = findViewById<HorizontalScrollView>(R.id.ScrollingImage)

        var x = 0;
        fun scroll() {
            mScrollView.smoothScrollTo(200, 10)
            Handler(Looper.getMainLooper()).postDelayed(scroll, 1000)
       }

       Handler(Looper.getMainLooper()).postDelayed({
           mScrollView.smoothScrollTo(200, 10)*/
     //   }, 1000)
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

    fun about_as(view: View) {
        val intent = Intent(this, AboutAs::class.java)
        startActivity(intent)
    }


}
