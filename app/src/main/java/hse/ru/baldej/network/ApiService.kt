package hse.ru.baldej.network

import hse.ru.baldej.responses.LoginResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("login_generate?"/*"login_generate?"*/)
    fun getRegistrationCode(@Query("email") email: String): Call<LoginResponse>
}