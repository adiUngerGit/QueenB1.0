package com.example.queenb

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

/**
 * Skeleton of an Android Things activity.
 *
 * Android Things peripheral APIs are accessible through the PeripheralManager
 * For example, the snippet below will open a GPIO pin and set it to HIGH:
 *
 * val manager = PeripheralManager.getInstance()
 * val gpio = manager.openGpio("BCM6").apply {
 *     setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW)
 * }
 * gpio.value = true
 *
 * You can find additional examples on GitHub: https://github.com/androidthings
 */
class send_whatsapp : AppCompatActivity() {

    val ISRAEL_AREA_CODE = "972"
    val URL_PREFIX = "https://api.whatsapp.com/send?phone="
    val URL_TEXT = "&text=היי%20אני%20מעוניינת%20לשמוע%20על%20QueenB"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_whatsapp)

        val standart_phone_number = "050*******" //TODO CHANGE THIS TO THE AMBASSADOR'S NUMBER


        val send_whatsapp_btn = findViewById(R.id.send_msg) as Button
        val number_with_area = ISRAEL_AREA_CODE + standart_phone_number.substring(1)


        send_whatsapp_btn.setOnClickListener {
            val url = URL_PREFIX + number_with_area + URL_TEXT
            SendWhatsappMsg(url)

        }
    }


    fun SendWhatsappMsg(url: String) {

        try {
            packageManager.getPackageInfo("com.whatsapp", PackageManager.GET_ACTIVITIES)
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)

            startActivity(i)


        } catch (e: PackageManager.NameNotFoundException) {
            Toast.makeText(this, "Whatsapp is not installed in your phone.", Toast.LENGTH_SHORT)
                .show()
            e.printStackTrace()
        }

    }
}
