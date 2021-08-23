package hse.ru.baldej.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.system.Os.remove
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import hse.ru.baldej.R
import hse.ru.baldej.databinding.FragmentLoginBinding
import hse.ru.baldej.databinding.FragmentProfileBinding
import hse.ru.baldej.ui.activities.MainActivity
import hse.ru.baldej.viewmodels.LoginViewModel


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            exit.setOnClickListener {
                (activity as MainActivity).apply {
                    val editor: SharedPreferences.Editor = mySharedPreferences!!.edit()
                    editor.remove(REGISTRATION_CODE_PREFERENCES)
                    editor.apply()
                    if (mySharedPreferences!!.contains(REGISTRATION_CODE_PREFERENCES)) {
                        Toast.makeText(context, "Не удалил", Toast.LENGTH_LONG).show()
                    }
                    navigationController.navigate(R.id.loginFragment)
                }
            }
            email.text = LoginFragment.email
            val name = LoginFragment.email.substringBefore("@")
            nameLastName.text = name
        }
    }


}