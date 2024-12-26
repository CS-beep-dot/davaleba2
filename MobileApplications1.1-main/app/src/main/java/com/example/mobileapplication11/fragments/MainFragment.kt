package com.example.mobileapplication11.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mobileapplication11.R
import com.example.mobileapplication11.databinding.FragmentMainBinding
import com.example.mobileapplication11.home.HomeFragment
import com.example.mobileapplication11.home.homePosts.HomePostsFragment
import com.example.mobileapplication11.profile.ProfileFragment

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFragment(HomePostsFragment.newInstance())
        bottomNavigationListener()
    }

    private fun bottomNavigationListener() = with(binding){
        bottomNavigationMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    loadFragment(HomePostsFragment.newInstance())
                    true
                }
                R.id.search -> {
                    Toast.makeText(requireContext(), "coming soon!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.add -> {
                    Toast.makeText(requireContext(), "coming soon!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.notifications -> {
                    Toast.makeText(requireContext(), "coming soon!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile -> {
                    loadFragment(ProfileFragment.newInstance())
                    true
                }
                else -> {
                    loadFragment(HomeFragment.newInstance())
                    true
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment){
        parentFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}