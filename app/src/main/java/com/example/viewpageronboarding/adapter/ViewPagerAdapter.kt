package com.example.viewpageronboarding.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpageronboarding.MainActivity

class ViewPagerAdapter(activity: FragmentActivity, fragments:ArrayList<Fragment>):FragmentStateAdapter(activity) {
    val fragment : ArrayList<Fragment> = fragments
    override fun getItemCount(): Int {
        return fragment.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragment[position]
    }
}