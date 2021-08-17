package hse.ru.baldej.viewmodels

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import hse.ru.baldej.repositories.LoginRepository
import hse.ru.baldej.responses.LoginResponse

class LoginViewModel(@NonNull application: Application) : AndroidViewModel(application) {
    private var loginRepository: LoginRepository =
        LoginRepository()

    fun registerAccount(login:String, password:String): LiveData<LoginResponse> {
        return loginRepository.registerAccount(login, password)
    }

}