package com.example.queenb

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_ambassadors.*
import kotlinx.android.synthetic.main.ambassador_cardview.view.*




class ambassadors : AppCompatActivity() {

    var profiles_list = ArrayList<ambassador_profile>()
    var allowed_cities = mutableListOf<String>();
    var allowed_ages = mutableListOf<String>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_ambassadors)
        create_ambassators()
        val myAddapter = MyAddapter(profiles_list, this)
        recycler_ambassador.layoutManager = LinearLayoutManager(this)
        recycler_ambassador.adapter = myAddapter
        restartListsCheckBox()
    }

    private fun restartListsCheckBox() {
        allowed_cities.add("ירושלים")
        allowed_cities.add("תל אביב")
        allowed_cities.add("חיפה")

        allowed_ages.add("י״א")
        allowed_ages.add("י'")
        allowed_ages.add("ט'")
        allowed_ages.add("ח'")

    }

    private fun create_ambassators() {
        // val tempInstagram = "ruti.popilov@mail.huji.ac.il" // todo delete this, add real ambassadors
        val profile1 = ambassador_profile(
            "מגל אופיר",
            "ירושלים",
            "י'",
            "'0528982213",
            "",
            "~ התכנית גרמה לי להתאהב במדעי המחשב ~"
        )
        val profile2 = ambassador_profile(
            "סביון פלורנס נחמן",
            "ירושלים",
            "י'",
            "0552281405",
            "https://www.instagram.com/savyon_nachman_/",
            "~ התאהבתי במדעי המחשב ~"

        )
        val profile3 = ambassador_profile(
            "גלי יפת",
            "ירושלים",
            "י'",
            "0587655524",
            "",
            "~ הזדמנות ענקית להתאהב ~"


        )
        val profile4 = ambassador_profile(
            "אליזבת בראודסקי",
            "ירושלים",
            "י'",
            "0534212372",
            "https://www.instagram.com/jackjack_167/",
            "~ נהנתי ללמוד את החומר בצורה כל כך כייפית ~"
        )


        val profile5 = ambassador_profile(
            "חנה שטילמן",
            "ירושלים",
            "י'",
            "0585372245",
            "https://www.instagram.com/hannah._.1200/",
            "~ הכרתי בנות באותו ראש ועברנו תהליך ביחד ~"
        )

        val profile6 = ambassador_profile(
            "ליה כנרי",
            "תל אביב",
            "י'",
            "0585551354",
            "https://www.instagram.com/wehateliya_/?igshid=33g9xc8ja6e0",
            "~ נפתחתי למשהו שפחדתי ממנו ~"
        )

        val profile7 = ambassador_profile(
            "יולי רוזנר",
            "תל אביב",
            "י'",
            "0532741014",
            "",
            "~ הזדמנות עצומה לקראת העתיד ~"
        )

        val profile8 = ambassador_profile(
            "סתיו חייקה",
            "ירושלים",
            "י״א",
            "0548170365",
            "https://www.instagram.com/stavhaike/",
            "~ גורם לך להאמין שאת יכולה לעשות הכל ~"
        )

        val profile9 = ambassador_profile(
            "נועה ניר",
            "חיפה",
            "ט'",
            "0543094460",
            "",
            "~ מעשיר את הידע ופותח אותך לתחומים חדשים ~"
        )
        val profile10 = ambassador_profile(
            "מאיה סמובסקי",
            "חיפה",
            "ט'",
            "0586714286",
            "",
            "~ נהנתי לתכנת אתר אינטרנט ולראות אותו פועל ~"
        )
        val profile11 = ambassador_profile(
            "עמליה סוכרי",
            "תל אביב",
            "י'",
            "0527202019",
            "https://www.instagram.com/amalia.sucary/",
            "~ זה פותח דלתות בהמשך ~"
        )

        val profile12 = ambassador_profile(
            "יובל בן עזרא",
            "חיפה",
            "ט'",
            "0549538121",
            "https://www.instagram.com/doby_fangirl/?r=nametag",
            "~ הכי אהבתי את המדריכות והחברות שהכרתי ~"
        )






        profiles_list.add(profile1)
        profiles_list.add(profile4)
        profiles_list.add(profile2)
        profiles_list.add(profile5)
        profiles_list.add(profile6)
        profiles_list.add(profile7)
        profiles_list.add(profile3)
        profiles_list.add(profile8)
        profiles_list.add(profile9)
        profiles_list.add(profile10)
        profiles_list.add(profile11)
        profiles_list.add(profile12)
    }
    class MyAddapter(val arrayList: ArrayList<ambassador_profile>, val context: Context) :
        RecyclerView.Adapter<MyAddapter.ViewHolder>() {
        val ISRAEL_AREA_CODE = "972"
        val URL_PREFIX = "https://api.whatsapp.com/send?phone="
        val URL_TEXT = "&text=היי%20אני%20מעוניינת%20לשמוע%20על%20QueenB"

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            fun bindItems(profile: ambassador_profile) {
                itemView.profile_name.text = profile.name
                itemView.profile_description.text =
                    profile.city + ", " + profile.grade
               // itemView.instagram.text = profile.instagram
                itemView.profile_sentence.text = profile.sentence

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.ambassador_cardview, parent, false)
            return ViewHolder(v)
        }

        override fun getItemCount(): Int {
            return arrayList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindItems(arrayList[position])

            //if whatsapp button pressed:

            holder.itemView.whatsapp_button.setOnClickListener {
                val standart_phone_number = arrayList[position].phone
                val number_with_area = ISRAEL_AREA_CODE + standart_phone_number.substring(1)
                val url = URL_PREFIX + number_with_area + URL_TEXT
                SendWhatsappMsg(url)

            }

            // if instegram pressed :

            holder.itemView.instagram_button.setOnClickListener {


            }

            //if  email button pressed:

//            holder.itemView.email_button.setOnClickListener {
//                send_email(arrayList[position].instagram)
//            }


        }


        fun send_email(email_to: String) {

            val full_msg = "אני מעוניינת לשמוע על QueenB"
            val it = Intent(Intent.ACTION_SEND)
            it.putExtra(
                Intent.EXTRA_EMAIL,
                arrayOf<String>(email_to)
            )
            it.putExtra(Intent.EXTRA_SUBJECT, "היי שגרירה של QueenB, מישהי רוצה להתייעץ איתך")
            it.putExtra(Intent.EXTRA_TEXT, full_msg)

            it.type = "message/rfc822"
            context.startActivity(Intent.createChooser(it, "בחרי אפליקציית מייל"))

        }

        fun GoInstegram(url: String) {

        }

        fun SendWhatsappMsg(url: String) {


            try {
                context.packageManager.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)

                context.startActivity(i)


            } catch (e: PackageManager.NameNotFoundException) {
                Toast.makeText(
                    context,
                    "Whatsapp is not installed in your phone.",
                    Toast.LENGTH_SHORT
                )
                    .show()
                e.printStackTrace()
            }

        }


    }

    // click on search to filtered
    fun searchByFilter(view: View) {
        var filtered = ArrayList<ambassador_profile>()

        for (profile in profiles_list) {
            if (profile.city in allowed_cities)
                if (profile.grade in allowed_ages)
                    filtered.add((profile))
        }
        if (filtered.size == 0) {
            Toast.makeText(this, "אווי.. איו בנות כאלה במאגר שלנו.\nאבל הי! אולי תהיה את המלכה הבאה!.", Toast.LENGTH_SHORT).show()

        }

        val myAddapter = MyAddapter(filtered, this)

        recycler_ambassador.layoutManager = LinearLayoutManager(this)
        recycler_ambassador.adapter = myAddapter

        openBox(View(this))
    }

    // click on any check box to filtered

    fun onCheckboxClicked(view: View) {

        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.jerusalem -> {
                    if (checked) {
                        allowed_cities.add("ירושלים")
                    }else {
                        allowed_cities.remove("ירושלים")
                    }
                }
                R.id.tel_aviv -> {
                    if (checked) {
                        allowed_cities.add("תל אביב")
                    } else {
                        allowed_cities.remove("תל אביב")
                    }
                }
                R.id.haifa -> {
                    if (checked) {
                        allowed_cities.add("חיפה")
                    } else {
                        allowed_cities.remove("חיפה")
                    }
                }
                R.id.fifteen -> {
                    if (checked) {
                        allowed_ages.add("י״א")
                    } else {
                        allowed_ages.remove("י״א")
                    }
                }
                R.id.fourteen -> {
                    if (checked) {
                        allowed_ages.add("י'")
                    } else {
                        allowed_ages.remove("י'")

                    }
                }
                R.id.thirteen -> {
                    if (checked) {
                        allowed_ages.add("ט'")
                    } else {
                        allowed_ages.remove("ט'")

                    }
                }
                R.id.thirteen -> {
                    if (checked) {
                        allowed_ages.add("ח'")
                    } else {
                        allowed_ages.remove("ח'")

                    }
                }
            }
        }




    }


    fun enterSign(view: View) {
        val url = "https://www.queenb.org.il/signup"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

    fun goHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun openBox(view: View) {
        var serch =
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.search_constraint)
        var parms = serch.layoutParams;

        if (parms.height > 10) {
            parms.height = 1
        } else {
            parms.height = 800

        }

        var ambassadors =
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.general_layout)
        var parms2 = ambassadors.layoutParams;

        if (parms2.height > 350) {
            parms2.height = 350
        } else {
            parms2.height = 1100

        }
        ambassadors.setLayoutParams(parms2);

        recycler_ambassador

        var recycler_ambassador =
            findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recycler_ambassador)
        var parms3 = recycler_ambassador.layoutParams;

        if (parms3.height > 350) {
            parms3.height = 350
        } else {
            parms3.height = 1100

        }
        recycler_ambassador.setLayoutParams(parms3);


    }


    }
