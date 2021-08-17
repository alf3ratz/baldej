package hse.ru.baldej.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import hse.ru.baldej.R
import hse.ru.baldej.databinding.FragmentConfirmBinding
import hse.ru.baldej.databinding.FragmentLoginBinding

class ConfirmFragment : Fragment() {

    private lateinit var binding: FragmentConfirmBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentConfirmBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            goBttn.setOnClickListener {
                if (codeConfirm.text.toString().toInt().equals(LoginFragment.confirmCode)) {
                    Toast.makeText(context, "Код совпадает!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}