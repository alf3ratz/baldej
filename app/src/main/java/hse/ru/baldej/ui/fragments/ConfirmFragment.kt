package hse.ru.baldej.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import hse.ru.baldej.R
import hse.ru.baldej.databinding.FragmentConfirmBinding
import hse.ru.baldej.ui.activities.MainActivity

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
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentConfirmBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            goBttn.setOnClickListener {
                if (codeConfirm.text.toString().toInt() == LoginFragment.confirmCode) {
                    (activity as MainActivity).apply {
                        menu.visibility = View.VISIBLE
                        navigationController.navigate(R.id.mainFragment)
                    }

                } else {
                    Toast.makeText(context, "Введён неверный код!", Toast.LENGTH_LONG).show()
                }
            }
            wrongCodeText.setOnClickListener {
                activity?.let {
                    val builder = AlertDialog.Builder(it)
                    builder.setTitle("Вернуться на страницу отправки кода?")
                        .setCancelable(true)
                        .setPositiveButton("ДА") { dialog, id ->
                            (activity as MainActivity).navigationController.navigate(R.id.loginFragment)
                        }
                        .setNegativeButton("Нет") { dialog, id ->
                            dialog.cancel()
                        }
                    builder.create().show()
                }
            }
        }

    }
}