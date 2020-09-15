package com.example.queenb

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import android.util.Log
import com.example.queenb.R

// ********************************************************************************************
// send request to email by opening a mail app:
//
//class contact_us : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_contact_us)
//
//
//        val send_contact_btn = findViewById(R.id.contact_btn) as Button
//        val name_edit = findViewById(R.id.contact_name) as EditText
//        val email_edit = findViewById(R.id.contact_email) as EditText
//        val subject_edit = findViewById(R.id.contact_subject) as EditText
//        val msg_edit = findViewById(R.id.contact_message) as EditText
//
//
//        send_contact_btn.setOnClickListener {
//
//
//            val name_text = name_edit.text.toString()
//            val email_text = email_edit.text.toString()
//            val subject_text = subject_edit.text.toString()
//            val msg_text = msg_edit.text.toString()
//
//            if (!valid_email(email_text)) {
//                Toast.makeText(this, "אימייל לא תקין", Toast.LENGTH_SHORT).show()
//
//
//            } else if (name_text.isEmpty()) {
//                Toast.makeText(this, "שם לא תקין", Toast.LENGTH_SHORT).show()
//            } else {
//                send_email(name_text, email_text, subject_text, msg_text)
//                name_edit.setText("")
//                email_edit.setText("")
//                subject_edit.setText("")
//                msg_edit.setText("")
////                Toast.makeText(this, "הפנייה נשלחה, נחזור אלייך בהקדם", Toast.LENGTH_LONG).show()
//
//            }
//
//
//        }
//
//
//    }
//
//    fun valid_email(given_email: String): Boolean {
//        return !TextUtils.isEmpty(given_email) && android.util.Patterns.EMAIL_ADDRESS.matcher(
//            given_email
//        ).matches()
//    }
//
//
//    protected fun send_email(name: String, email: String, subject: String, msg: String) {
//
//        val full_msg = "היי QueenB" + "\n" +
//                "התקבלה דרך האפליקציה פנייה מ: " + name + "\n" + "כתובת מייל: " + email + "\n" + "תוכן הפנייה: " + "\n\n" + msg
//        val it = Intent(Intent.ACTION_SEND)
//        it.putExtra(
//            Intent.EXTRA_EMAIL,
//            arrayOf<String>("ruti.popilov@mail.huji.ac.il")
//        ) //todo change to queenB mail!
//        it.putExtra(Intent.EXTRA_SUBJECT, subject)
//        it.putExtra(Intent.EXTRA_TEXT, full_msg)  //todo do i even need a mail???
//
//        it.type = "message/rfc822"
////        startActivity(Intent.createChooser(it, "בחרי אפליקציית מייל"))
//        startActivityForResult(Intent.createChooser(it, "בחרי אפליקציית מייל"), 0);
//
//
//    }
//
//
//}
// ********************************************************************************************





// ********************************************************************************************
// send request to google sheets file :
//

class contact_us : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        val send_contact_btn = findViewById(R.id.contact_btn) as Button
        val name_edit = findViewById(R.id.contact_name) as EditText
        val email_edit = findViewById(R.id.contact_email) as EditText
        val subject_edit = findViewById(R.id.contact_subject) as EditText
        val msg_edit = findViewById(R.id.contact_message) as EditText


        send_contact_btn.setOnClickListener {


            val name_text = name_edit.text.toString()
            val email_text = email_edit.text.toString()
            val subject_text = subject_edit.text.toString()
            val msg_text = msg_edit.text.toString()

            if (!valid_email(email_text)) {
                Toast.makeText(this, "אימייל לא תקין", Toast.LENGTH_SHORT).show()


            } else if (name_text.isEmpty()) {
                Toast.makeText(this, "שם לא תקין", Toast.LENGTH_SHORT).show()
            } else {

                addItemToSheet(name_text,email_text,subject_text, msg_text)


                name_edit.setText("")
                email_edit.setText("")
                subject_edit.setText("")
                msg_edit.setText("")

            }


        }


    }

    fun valid_email(given_email: String): Boolean {
        return !TextUtils.isEmpty(given_email) && android.util.Patterns.EMAIL_ADDRESS.matcher(
            given_email
        ).matches()
    }




    protected fun addItemToSheet(name: String, email: String, subject: String, msg: String) {

        val stringRequest = object: StringRequest(
            Request.Method.POST, "https://script.google.com/macros/s/AKfycbwx4jzM77uYnsgoIYExl9iN9B1zkwAcqd1IYCJLAHog99MzOWXP/exec",
            object: Response.Listener<String> { //todo change to a queenB designated file and script!
                override fun onResponse(response:String) {
                    Toast.makeText(this@contact_us, "הפנייה נשלחה", Toast.LENGTH_LONG).show()

//                    val intent = Intent(getApplicationContext(), contact_us::class.java)
//                    startActivity(intent)
                }
            },

            object: Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError) {
                    Toast.makeText(this@contact_us, "תקלה, ההפנייה לא נשלחה", Toast.LENGTH_LONG).show()

                }
            }
        ) {
            @Override
            override fun getParams():Map<String, String> {
                //here we pass params

                var parmas = mutableMapOf<String, String>()
                parmas.put("action", "addItem")
                parmas.put("requestName", name)
                parmas.put("requestEmail", email)
                parmas.put("requestSubject", subject)
                parmas.put("requestMsg", msg)
                return parmas
            }
        }
        val socketTimeOut = 50000// u can change this .. here it is 50 seconds
        val retryPolicy = DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        stringRequest.setRetryPolicy(retryPolicy)
        val queue = Volley.newRequestQueue(this)
        queue.add(stringRequest)
    }


}


