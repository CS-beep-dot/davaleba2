package com.example.mobileapplication11.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(f : FragmentActivity, val fList: List<Fragment>) : FragmentStateAdapter(f){

    override fun getItemCount() = fList.size

    override fun createFragment(position: Int): Fragment {
        return fList[position]
    }
}