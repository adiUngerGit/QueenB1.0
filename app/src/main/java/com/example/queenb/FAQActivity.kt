package com.example.queenb

import android.os.Bundle
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
}