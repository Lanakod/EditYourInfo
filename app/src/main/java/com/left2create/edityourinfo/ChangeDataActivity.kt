package com.left2create.edityourinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

lateinit var name: EditText
lateinit var phone: EditText

class ChangeDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_data)

        name = findViewById(R.id.personName)
        phone = findViewById(R.id.phoneNumber)

        if(intent.hasExtra("name") && intent.hasExtra("phone"))
        {
            name.setText(intent.getStringExtra("name"))
            phone.setText(intent.getStringExtra("phone"))
        }
    }

    fun acceptClick(view: View)
    {
        val changedIntent = Intent(applicationContext, MainActivity::class.java)
        changedIntent.putExtra("name", name.text.toString())
        changedIntent.putExtra("phone", phone.text.toString())
        startActivity(changedIntent)
        finish()
    }
}