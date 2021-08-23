package hse.ru.baldej.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import hse.ru.baldej.R
import hse.ru.baldej.adapters.ViewPagerAdapter
import hse.ru.baldej.databinding.FragmentMainBinding
import hse.ru.baldej.ui.activities.MainActivity

class MainFragment : Fragment() {


    //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(
            binding.tabLayout,
            binding.viewPager
        ) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.my_trips_str)
                1 -> tab.text = getString(R.string.companions_str)
            }
        }.attach()
        binding.apply {
            currentText.setTextColor(Color.BLACK)
            historyText.setOnClickListener {
                (activity as MainActivity).navigationController.navigate(R.id.historyFragment)
            }
        }
    }
}