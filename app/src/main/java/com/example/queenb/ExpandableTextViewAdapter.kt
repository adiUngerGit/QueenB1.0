package com.example.queenb

import android.content.Context
import android.graphics.Typeface
import android.text.SpannedString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import androidx.core.content.res.TypedArrayUtils.getText

class ExpandableTextViewAdapter(var context: Context) :

    BaseExpandableListAdapter() {

    var QUESTION1 = "מי אנחנו?"
    var QUESTION2 = "מה משמעות השם QueenB?"
    var QUESTION3 = "איפה מתקיימת הפעילות?"
    var QUESTION4 = "איך מתקיימת הפעילות בסגר?"
    var QUESTION5 = "איך אני נרשמת לתכנית?"
    var QUESTION6 = "למה כדאי לנערה בת 14 ללמוד לתכנת?"

    var ANSWER1 =
        "העמותה QueenB הוקמה על ידי סטודנטיות למדעי המחשב מהאוניברסיטה העברית לאור מיעוט הנשים סביבן," +
                " במטרה להעלות את מספר הנשים הבוחרות לעסוק במקצועות טכנולוגיים" +
                "  ובכך לשמר את מעמדה של מדינת ישראל כמעצמת הייטק."
    var ANSWER2 =
        "משמעות אחת נובעת מהביטוי queen bee, מלכת הדבורים - נקבה חזקה בטבע וביטוי שגור" +
                " בשפה האנגלית לבחורה חזקה ומובילה. משמעות נוספת נובעת מהמילה be, היה לנו חשוב דרך השם להעביר את החשיבות שאנחנו רואות בכך שתהיי עצמך - תגשימי את עצמך " +
                "בצורה מלאה ותגדירי את עצמך ללא תלות בתכתיבי החברה. כמובן שהקריצה לביונסה לא מקרית."

    var ANSWER6 =
                "ענף ההייטק הוא הענף היציב והרווחי ביותר במשק הישראלי, במיוחד היום. חברות ההייטק מחפשות עוד ועוד כח אדם מתאים ומבינות את החשיבות שבגיוון אנושי. לימוד תכנות היא נקודת פתיחה שיכולה להבטיח עצמאות כלכלית.\n" +
                "\n" +
                "תכנות הוא לא רק כלי שמבטיח עתיד מקצועי. ביחד אנחנו לומדות להיות בטוחות יותר בעצמנו, להיות אמיצות להתנסות בתחומים חדשים, מחזקות את עצמנו ואחת את השנייה."

    var ANSWER3 =
        "העמותה פועלת בקרב אוכלוסיית הסטודנטיות למדעי המחשב ברחבי הארץ:\n" +
                "-תל אביב\n" +
                "-ירושלים\n" +
                "-בחיפה\n" +
                "-באר שבע\n" +
                "-מודיעין\n" +
                "-הרצליה\n" +
                "-הרצליה\n" +
                "לרשימה המפורטת של המוקדים והרשמה היכנסי לכאן https://www.queenb.org.il/signup"
    var ANSWER4 = "אנחנו ממשיכות גם באונליין!\n בשלב זה אנחנו נערכות לפתיחת השנה עם נוכחות פיזית במוקדי הפעילות שלנו, אך המצב עשוי להשתנות בכל עת בהתאם להנחיות משרדי החינוך והבריאות.\n" +
            "\n" +
            "במקרה כזה הפעילות שלנו תעבור במתכונת היברידית, המשלבת מפגשי תכנות אונליין ומפגשים קבוצתיים באוויר הפתוח. אל תדאגו, יש לנו כבר ארבעה חודשי ניסיון ואת כל מה שדרוש כדי להעביר את הפעילות שלנו בצורה הכי איכותית, שלמה ומהנה גם בצל ההגבלות."
    var ANSWER5 = "מוזמנת להרשם בלינק הבא https://www.queenb.org.il/signup ונהיה בקשר בקרוב."

    var questions =
        arrayOf(QUESTION1, QUESTION2, QUESTION6, QUESTION3, QUESTION4, QUESTION5)
    var answers = arrayOf(
        arrayOf(ANSWER1),
        arrayOf(ANSWER2),
        arrayOf(ANSWER6),
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