
package com.example.mobileapplication11.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.mobileapplication11.R
import com.example.mobileapplication11.adapters.ViewPagerAdapter
import com.example.mobileapplication11.home.homePosts.HomePostsFragment
import com.example.mobileapplication11.profile.ProfileFragment

class HomeFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        
        // Initialize ViewPager
        viewPager = view.findViewById(R.id.viewPager)
        viewPagerAdapter = ViewPagerAdapter(requireActivity())
        
        // Add Fragments to the Adapter
        viewPagerAdapter.addFragment(HomePostsFragment())
        viewPagerAdapter.addFragment(ProfileFragment())
        
        // Attach Adapter to ViewPager
        viewPager.adapter = viewPagerAdapter

        return view
    }
}
