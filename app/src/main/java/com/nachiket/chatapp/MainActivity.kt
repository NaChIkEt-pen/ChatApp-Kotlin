package com.nachiket.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.nachiket.chatapp.ApiFolder.Chats
import com.nachiket.chatapp.ApiFolder.MyApi
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    public lateinit var BroadId  : String
    public lateinit var UserName :String

    private val BaseUrl = "http://35.154.204.87:3000/"
    private val Tag = "Check"
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
        BroadId = broadIdInp.text.toString()
        val userNameInp = findViewById<EditText>(R.id.UserNameInp)
        UserName = userNameInp.text.toString()

        Toast.makeText(this, "$BroadId $UserName" , Toast.LENGTH_SHORT).show()

        val API = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        API.getChats(BroadId).enqueue(object : Callback<List<Chats>>{
            override fun onResponse(call: Call<List<Chats>>, response: Response<List<Chats>>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        for(chat in it){
                            Log.i(Tag, "${chat.time}")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Chats>>, t: Throwable) {
                Log.i(Tag,"onFailure ${t.message}")
            }

        })
    }
}