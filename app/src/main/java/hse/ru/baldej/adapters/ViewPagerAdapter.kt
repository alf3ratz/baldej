package hse.ru.baldej.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import hse.ru.baldej.ui.fragments.CompanionsFragment
import hse.ru.baldej.ui.fragments.MyTripsFragment

class ViewPagerAdapter(fragmentManager: Fragment) : FragmentStateAdapter(fragmentManager) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        Log.i("adapter", "ya tut bil")
        return when (position) {
            0 -> MyTripsFragment()
            1 -> CompanionsFragment()
            else -> MyTripsFragment()
        }

    }
}