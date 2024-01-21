package com.nachiket.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inpBtn = findViewById<Button>(R.id.InpBtn)
        inpBtn.setOnClickListener{
            getInput()
        }
    }

    private fun getInput(){
        val broadIdInp = findViewById<EditText>(R.id.BroadIdInp)
        val BroadId = broadIdInp.text
        val userNameInp = findViewById<EditText>(R.id.UserNameInp)
        val UserName = userNameInp.text

        Toast.makeText(this, "$BroadId $UserName" , Toast.LENGTH_SHORT).show()
    }
}