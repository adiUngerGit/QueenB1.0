package com.example.queenb

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class ExpandableTextViewAdapter(var context: Context) :
    BaseExpandableListAdapter() {
    var QUESTION1 = "מי אנחנו?"
    var QUESTION2 = "מה משמעות השם QueenB?"
    var QUESTION3 = "איפה מתקיימת הפעילות של העמותה?"
    var QUESTION4 = "איך אני נרשמת לתכנית?"
    var QUESTION5 = "איך תתקיים הפעילות אם יהיה סגר?"
    var ANSWER1 =
        "היא עמותה שהקומה על ידי סטודנטיות למדעי המחשב מהאוניברסיטה העברית לאור מיעוט הנשים סביבן," +
                "  במטרה להעלות את מספר הנשים הבוחרות לעסוק במקצועות טכנולוגיים" +
                "  ובכך לשמר את מעמדה של מדינת ישראל כמעצמת הייטק."
    var ANSWER2 =
        "משמעות אחת נובעת מהביטוי queen bee, מלכת הדבורים - נקבה חזקה בטבע וביטוי שגור" +
                " בשפה האנגלית לבחורה חזקה ומובילה. משמעות נוספת נובעת מהמילה be, היה לנו חשוב דרך השם להעביר את החשיבות שאנחנו רואות בכך שתהיי עצמך - תגשימי את עצמך " +
                "בצורה מלאה ותגדירי את עצמך ללא תלות בתכתיבי החברה. כמובן שהקריצה לביונסה לא מקרית."
    var ANSWER3 =
        "העמותה פועלת בקרב אוכלוסיית הסטודנטיות למדעי המחשב בשישה מוקדים בארץ:\n" +
                "-אוניברסיטת תל אביב\n" +
                "-האוניברסיטה העברית\n" +
                "-הטכניון בחיפה\n" +
                "-אוניברסיטת בן גוריון בבאר שבע\n" +
                "-בחרת Western digital בכפר סבא\n" +
                "-JestHUB"
    var ANSWER4 = "מוזמנת להרשם בדף זה ונהיה בקשר בקרוב."
    var ANSWER5 =
        "אם לא יהיה סגר, ניפגש במוקדים ברחבי הארץ. במקרה של סגר נעבור לזום."
    var questions =
        arrayOf(QUESTION1, QUESTION2, QUESTION3, QUESTION4, QUESTION5)
    var answers = arrayOf(
        arrayOf(ANSWER1),
        arrayOf(ANSWER2),
        arrayOf(ANSWER3),
        arrayOf(ANSWER4),
        arrayOf(ANSWER5)
    )

    override fun getGroupCount(): Int {
        return questions.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return answers[groupPosition].size
    }

    override fun getGroup(groupPosition: Int): Any {
        return questions[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return answers[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View? {
        var convertView = convertView
        val question = getGroup(groupPosition) as String
        if (convertView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.faq_question, null)
        }
        val question2 = convertView?.findViewById<TextView>(R.id.feqTitleView)
        question2?.setTypeface(null, Typeface.BOLD)
        question2?.text = question
        return convertView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup
    ): View? {
        var convertView = convertView
        val answer = getChild(groupPosition, childPosition) as String
        if (convertView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.faq_answer, null)
        }
        val answer2 = convertView?.findViewById<TextView>(R.id.descriptionFaqView)
        answer2?.text = answer
        return convertView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return false
    }

}