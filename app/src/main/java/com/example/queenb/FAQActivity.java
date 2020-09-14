package com.example.queenbapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class FAQActivity extends AppCompatActivity {

    ExpandableListView expandableTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        expandableTextView = findViewById(R.id.eTV);
        ExpandableTextViewAdapter adapter = new ExpandableTextViewAdapter(FAQActivity.this);
        expandableTextView.setAdapter(adapter);

    }
}
