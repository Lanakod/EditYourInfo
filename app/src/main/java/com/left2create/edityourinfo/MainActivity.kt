package com.left2create.edityourinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

var nameStr: String = ""
var phoneStr: String = ""

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(intent.hasExtra("name") && intent.hasExtra("phone"))
        {
            nameStr = intent.getStringExtra("name").toString()
            phoneStr = intent.getStringExtra("phone").toString()

            findViewById<TextView>(R.id.textView).setText("Добро пожаловать, %s \n Номер: %s".format(
                nameStr, phoneStr))
        }
    }

    fun changeDataClick(view: View)
    {
        val swapToChange = Intent(applicationContext, ChangeDataActivity::class.java)
        swapToChange.putExtra("name", nameStr)
        swapToChange.putExtra("phone", phoneStr)
        startActivity(swapToChange)
        finish()
    }
}