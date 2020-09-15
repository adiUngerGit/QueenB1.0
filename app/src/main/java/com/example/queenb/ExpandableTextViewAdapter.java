package com.example.queenb;


import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExpandableTextViewAdapter extends BaseExpandableListAdapter {
    Context context;
    String QUESTION1 = "מי אנחנו?";
    String QUESTION2 = "מה משמעות השם QuennB?";
    String QUESTION3 = "איפה מתקיימת הפעילות של העמותה?";
    String QUESTION4 = "איך אני נרשמת לתכנית?";
    String QUESTION5 = "איך תתקיים הפעילות אם יהיה סגר?";

    String ANSWER1 = "היא עמותה שהקומה על ידי סטודנטיות למדעי המחשב מהאוניברסיטה העברית לאור מיעוט הנשים סביבן," +
            "  במטרה להעלות את מספר הנשים הבוחרות לעסוק במקצועות טכנולוגיים" +
            "  ובכך לשמר את מעמדה של מדינת ישראל כמעצמת הייטק.";
    String ANSWER2 = "משמעות אחת נובעת מהביטוי queen bee, מלכת הדבורים - נקבה חזקה בטבע וביטוי שגור" +
            " בשפה האנגלית לבחורה חזקה ומובילה. משמעות נוספת נובעת מהמילה be, היה לנו חשוב דרך השם להעביר את החשיבות שאנחנו רואות בכך שתהיי עצמך - תגשימי את עצמך " +
            "בצורה מלאה ותגדירי את עצמך ללא תלות בתכתיבי החברה. כמובן שהקריצה לביונסה לא מקרית.";
    String ANSWER3 = "העמותה פועלת בקרב אוכלוסיית הסטודנטיות למדעי המחשב בשישה מוקדים בארץ:\n" +
            "-אוניברסיטת תל אביב\n" +
            "-האוניברסיטה העברית\n" +
            "-הטכניון בחיפה\n" +
            "-אוניברסיטת בן גוריון בבאר שבע\n" +
            "-בחרת Western digital בכפר סבא\n" +
            "-JestHUB";
    String ANSWER4 = "מוזמנת להרשם בדף זה ונהיה בקשר בקרוב.";
    String ANSWER5 = "אם לא יהיה סגר, ניפגש במוקדים ברחבי הארץ. במקרה של סגר נעבור לזום.";



    String[] questions = {QUESTION1, QUESTION2, QUESTION3, QUESTION4, QUESTION5};

    String[][] answers = {{ANSWER1},{ANSWER2}, {ANSWER3}, {ANSWER4}, {ANSWER5}};


    public ExpandableTextViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return questions.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return answers[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return questions[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return answers[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String question = (String) getGroup(groupPosition);
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faq_title, null);

        }

        TextView question2 = convertView.findViewById(R.id.feqTitleView);
        question2.setTypeface(null, Typeface.BOLD);
        question2.setText(question);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String answer= (String) getChild(groupPosition, childPosition);

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faq_answers, null);

        }

        TextView answer2 = convertView.findViewById(R.id.descriptionFaqView);
        answer2.setText(answer);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
