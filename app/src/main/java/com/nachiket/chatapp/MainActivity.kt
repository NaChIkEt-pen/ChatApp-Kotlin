package com.nachiket.chatapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nachiket.chatapp.ApiFolder.Chats
import com.nachiket.chatapp.ApiFolder.MyApi
import com.nachiket.chatapp.Pages.ChatPage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    var BroadId  : String ="";
    var UserName :String = "";

//nachi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inpBtn = findViewById<Button>(R.id.InpBtn)
        inpBtn.setOnClickListener{
            getInput()
            if(BroadId != "" && UserName!=""){
                //Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
                val Intent = Intent(this, ChatPage::class.java)
                val bundle = Bundle()
                bundle.putString("BroadId", BroadId);
                bundle.putString("UserName", UserName);
                Intent.putExtras(bundle)
                startActivity(Intent)
            }

        }
    }

    private fun getInput(){
        val broadIdInp = findViewById<EditText>(R.id.BroadIdInp)
        BroadId = broadIdInp.text.toString()
        val userNameInp = findViewById<EditText>(R.id.UserNameInp)
        UserName = userNameInp.text.toString()
    }
}