package com.nachiket.chatapp.ApiFolder

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface MyApi {
    @GET("/{BroadID}")
    fun getChats(@Path("BroadID") ID : String  ): Call<List<Chats>>

}
