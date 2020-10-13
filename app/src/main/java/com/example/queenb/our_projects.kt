package com.example.queenb

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity

class our_projects : AppCompatActivity() {
    var listView: ListView? = null
    var mTitle = arrayOf(
        "תקועה בסגר? קראי ספר!",
        "סיוע לנשים בסיכון",
        "גלי את התחביבים שלך!",
        "Kiri-19"
    )
    var Project1_Description = "שאלון התאמה שיתאים לך ז'אנר ספרותי והמלצות לספרים. "
    var Project2_Description =
        "אתר המציע פיתרון לנשים בסיכון מוגבר לאלימות להזעיק עזרה בחשאי."
    var Project3_Description = "שאלון התאמה לתחומי עניין. "
    var Project4_Description = "אתר המשמש כעוזר אישי בתקופת הקורונה " +
            "המציע רעיונות לפעילויות או עזרה בקניות!"
    var mDescription = arrayOf(
        Project1_Description,
        Project2_Description,
        Project3_Description,
        Project4_Description
    )
    var images =
        intArrayOf(R.drawable.site_1, R.drawable.site_2new, R.drawable.site_3, R.drawable.site_4)
    var links = arrayOf(
        "https://books--leahshl.repl.co/",
        "https://hacaton2020--lyvrmvzs.repl.co/",
        "https://orangereddisguisedadaware.shaharl6000.repl.co/",
        "https://hack-besafe--linoypalas.repl.co/index.html"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_our_projects)
        listView = findViewById(R.id.listView)
        val adapter =
            MyAdapter(
                this,
                mTitle,
                mDescription,
                links,
                images
            )

        this.listView?.setAdapter(adapter)
        this.listView?.setOnItemClickListener(OnItemClickListener { adapterView, view, position, id ->
            if (position == 0) {
                Toast.makeText(this, "Project1", Toast.LENGTH_SHORT).show()
            }
            if (position == 0) {
                Toast.makeText(this, "Project2", Toast.LENGTH_SHORT).show()
            }
            if (position == 0) {
                Toast.makeText(this, "Project3", Toast.LENGTH_SHORT).show()
            }
            if (position == 0) {
                Toast.makeText(this, "Project4", Toast.LENGTH_SHORT).show()
            }
        })
    }

    internal inner class MyAdapter(
        context: Context,
        var rTitle: Array<String>,
        var rDescription: Array<String>,
        var rLink: Array<String>,
        var rImgs: IntArray
    ) :
        ArrayAdapter<String?>(context, R.layout.row, R.id.textView1, rTitle) {
        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {
            val layoutInflater =
                applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val row: View = layoutInflater.inflate(R.layout.row, parent, false)
            val images =
                row.findViewById<ImageView>(R.id.image)
            val myTitle = row.findViewById<TextView>(R.id.textView1)
            val myDescription = row.findViewById<TextView>(R.id.textView2)
            //TextView myLink = row.findViewById(R.id.textView3);
            images.setImageResource(rImgs[position])
            myTitle.text = rTitle[position]
            myDescription.text = rDescription[position]
            //myLink.setText(rLink[position]);
            row.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(rLink[position])
                startActivity(i)
            }
            return row
        }

    }

    fun goHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}