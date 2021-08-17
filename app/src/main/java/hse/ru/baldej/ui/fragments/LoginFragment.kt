package hse.ru.baldej.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import hse.ru.baldej.R
import hse.ru.baldej.databinding.FragmentLoginBinding
import hse.ru.baldej.responses.LoginResponse
import hse.ru.baldej.ui.activities.MainActivity
import hse.ru.baldej.viewmodels.LoginViewModel


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    companion object{
        var confirmCode = 0
    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.javaObjectType)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            goBttn.setOnClickListener {
                val login = loginEdit.text.toString()
                val password = passwordEdit.text.toString()
                if (login.isNotBlank() && login.isNotEmpty() && password.isNotBlank() && password.isNotEmpty()
                ) {
                    if (login.endsWith("@hse.ru") || login.endsWith("@edu.hse.ru")) {
//                        if (viewModel.registerAccount(login, password)) {
////
////                        }
                        Log.i("fail",login)
                        viewModel.registerAccount(login,password).observe((activity as MainActivity),{ response: LoginResponse? ->
                            if(response != null){
                                    confirmCode = response.registrationCode
                                        //(activity as MainActivity).navigationController.navigate(R.id.fragment_confirm)
                            }else{
                                Toast.makeText(context,"null",Toast.LENGTH_LONG).show()
                            }
                        })
                    }
                } else {
                    Toast.makeText(context, "Заполните все поля правильно", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

    }


}