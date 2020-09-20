package com.example.queenb


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
//import com.plattysoft.leonids.ParticleSystem


class Finall : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finall)

    }

    fun backHome(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}