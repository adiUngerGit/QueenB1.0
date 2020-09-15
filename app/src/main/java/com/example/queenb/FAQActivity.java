package com.example.queenb;
// this is a test (to see how push/pull work)

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

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
