package hse.ru.baldej.repositories

import android.util.Log
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import hse.ru.baldej.network.ApiClient
import hse.ru.baldej.network.ApiService
import hse.ru.baldej.responses.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class LoginRepository {
//    private val auth = FirebaseAuth.getInstance()
    private var apiService: ApiService = ApiClient.getRetrofit().create(ApiService::class.java)

    fun registerAccount(login:String, password:String): LiveData<LoginResponse> {
        val data: MutableLiveData<LoginResponse> = MutableLiveData()
        apiService.getRegistrationCode(login).enqueue(object : Callback<LoginResponse> {
            override fun onFailure(@NonNull call: Call<LoginResponse>, t: Throwable) {

                Log.i("fail",t.message.toString().plus("\n").plus(call.request().toString()))
                data.value = null
            }
            override fun onResponse(
                @NonNull call: Call<LoginResponse>,
                @NonNull response: Response<LoginResponse>
            ) {
                Log.i("fail","ne upalo")
                Log.i("fail",response.message().toString())
                data.value = response.body()
            }
        })
        return data
       // var result = false

//        auth.createUserWithEmailAndPassword(login,password).addOnCompleteListener {task ->
//            if(task.isSuccessful){
//                result = true
//            }else{
//
//            }
//        }
        //return result
    }
}