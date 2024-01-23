package com.nachiket.chatapp.Pages

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.nachiket.chatapp.ApiFolder.Chats
import com.nachiket.chatapp.ApiFolder.MyApi
import com.nachiket.chatapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChatPage : AppCompatActivity() {
    public lateinit var BroadId:String
    public lateinit var UserName : String


    private val BaseUrl = "http://35.154.204.87:3000/"
    private val Tag = "Check"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_page)

        val bundle = intent.extras
        BroadId = bundle?.getString ("BroadId").toString();
        Toast.makeText(this,BroadId,Toast.LENGTH_SHORT).show()
        UserName = bundle?.getString ("UserName").toString();

        getChatData()
    }

    private fun getChatData() {
        val API = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        API.getChats(BroadId).enqueue(object : Callback<List<Chats>> {
            override fun onResponse(call: Call<List<Chats>>, response: Response<List<Chats>>) {
                if(response.isSuccessful){
                    response.body()?.let {
                        for(chat in it){
                            println(chat.time)
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