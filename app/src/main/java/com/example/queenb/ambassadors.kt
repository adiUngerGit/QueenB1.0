package com.example.queenb

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_ambassadors.*
import kotlinx.android.synthetic.main.ambassador_cardview.view.*

//import sun.jvm.hotspot.utilities.IntArray


class ambassadors : AppCompatActivity() {

    val profiles_list= ArrayList<ambassador_profile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ambassadors)
        create_ambassators()
        val myAddapter= MyAddapter(profiles_list,this)
        recycler_ambassador.layoutManager= LinearLayoutManager(this)
        recycler_ambassador.adapter=myAddapter
    }

    private fun create_ambassators() {
        val profile1 = ambassador_profile("שרון","jerusalem","ח","ברנר","0505905059")
        val profile2 = ambassador_profile("שירה","jerusalem","י״א","ברנר","0505905059")
        val profile3 = ambassador_profile("שיר","jerusalem","י","ברנר","0505905059")
        val profile4 = ambassador_profile("שני","jerusalem","ח","ברנר","0505905059")
        val profile5 = ambassador_profile("שולמית","jerusalem","ח","ברנר","0505905059")
        profiles_list.add(profile1)
        profiles_list.add(profile2)
        profiles_list.add(profile3)
        profiles_list.add(profile4)
        profiles_list.add(profile5)
    }






    class MyAddapter(val arrayList: ArrayList<ambassador_profile>, val context: Context):
        RecyclerView.Adapter<MyAddapter.ViewHolder>() {
        class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
            fun bindItems (profile: ambassador_profile){
                itemView.profile_name.text = profile.name
                itemView.profile_description.text= profile.city +", "+profile.grade+", "+profile.school

            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.ambassador_cardview,parent,false)
            return ViewHolder(v)
        }

        override fun getItemCount(): Int {
            return arrayList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bindItems(arrayList[position])

            holder.itemView.setOnClickListener {
                Toast.makeText(context,"you clicked a card",Toast.LENGTH_SHORT).show()//todo change this msg ruti
            }
        }
    }
}
