package hse.ru.baldej.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hse.ru.baldej.R
import hse.ru.baldej.databinding.FragmentAdvertisementBinding

class AdvertisementFragment : Fragment() {

    private lateinit var binding: FragmentAdvertisementBinding
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
        binding = FragmentAdvertisementBinding.inflate(inflater, container, false)
        return binding.root
    }


}