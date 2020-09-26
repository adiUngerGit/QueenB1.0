package com.example.queenb

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import androidx.appcompat.app.AppCompatActivity

class FAQActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_f_a_q)
        var expandableTextView: ExpandableListView? = null
        expandableTextView = findViewById(R.id.eTV)
        val adapter = ExpandableTextViewAdapter(this@FAQActivity)
        expandableTextView.setAdapter(adapter)
    }

    fun goHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}