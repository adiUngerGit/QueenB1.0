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


    }

    private fun create_ambassators() {
       // val tempInstagram = "ruti.popilov@mail.huji.ac.il" // todo delete this, add real ambassadors
        val profile1 = ambassador_profile(
            "מגל אופיר",
            "ירושלים",
            "15",
            "ברנר",
            "'0528982213",
            "",
        "התכנית גרמה לי להתאהב במדעי המחשב"
        )
        val profile2 = ambassador_profile(
            "סביון פלורנס נחמן",
            "ירושלים",
            "15.5",
            "ברנר",
            "0552281405",
            "@savyon_nachman_",
            "התכנית גרמה לי להתאהב במדעי המחשב, שזה תחום שלא הרבה בנות הולכות אליו"

        )
        val profile3 = ambassador_profile(
            "גלי יפת",
            "ירושלים",
            "15",
            "ברנר",
            "0587655524",
            "",
            "כי זה פותח כל כך הרבה דלתות בחיים ומראה עולם כל כך גדול ומעניין, הזדמנות ענקית לכל נערה להתאהב!"

        )
//        val profile4 = ambassador_profile(
//            "שני",
//            "jerusalem",
//            "16",
//            "ברנר",
//            "0523515506",
//
//        )
//        val profile5 = ambassador_profile(
//            "שולמית",
//            "jerusalem",
//            "15",
//            "ברנר",
//            "0505905057",
//
//        )

        profiles_list.add(profile1)
        profiles_list.add(profile2)
        profiles_list.add(profile3)
//        profiles_list.add(profile4)
//        profiles_list.add(profile5)
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
                    profile.city + ", " + profile.age + ", " + profile.school
               // itemView.instagram.text = profile.instagram
               // itemView.sentence.text = profile.sentence

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
                if (profile.age in allowed_ages)
                    filtered.add((profile))
        }

        val myAddapter = MyAddapter(filtered, this)

        recycler_ambassador.layoutManager = LinearLayoutManager(this)
        recycler_ambassador.adapter = myAddapter

    }

    // click on any check box to filtered

    fun onCheckboxClicked(view: View) {

        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.jerusalem -> {
                    if (checked) {
                        allowed_cities.add("ירושלים")
                    }
                }
                R.id.tel_aviv -> {
                    if (checked) {
                       allowed_cities.add("תל אביב")
                    }
                }
                R.id.haifa -> {
                    if (checked) {
                        allowed_cities.add("חיפה")
                    }
                }
                R.id.fifteen -> {
                    if (checked) {
                        allowed_ages.add("15")
                    }
                }
                R.id.sixteen -> {
                    if (checked) {
                        allowed_ages.add("16")
                    }
                }
                R.id.fourteen -> {
                    if (checked) {
                        allowed_ages.add("14")
                    }
                }
            }
        }




    }

    fun goHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
