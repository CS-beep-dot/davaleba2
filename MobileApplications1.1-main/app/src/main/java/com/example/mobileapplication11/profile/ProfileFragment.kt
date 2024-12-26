package com.example.mobileapplication11.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileapplication11.databinding.FragmentProfileBinding
import com.example.mobileapplication11.models.Highlights
import com.example.mobileapplication11.adapters.HighlightsAdapter
import com.example.mobileapplication11.adapters.ViewPagerAdapter
import com.example.mobileapplication11.profile.profileFragments.MainUserPostsFragment
import com.example.mobileapplication11.profile.profileFragments.MainUserTaggedFragment
import com.google.android.material.tabs.TabLayoutMediator

class ProfileFragment : Fragment() {

    private lateinit var binding : FragmentProfileBinding

    private lateinit var adapter: HighlightsAdapter

    private val fList = listOf(
        MainUserPostsFragment.newInstance(),
        MainUserTaggedFragment.newInstance()
    )

    private val tList = listOf("POSTS","TAGGED")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initRV()
    }

    private fun initRV() = with(binding) {
        rvHighlights.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        adapter = HighlightsAdapter()
        rvHighlights.adapter = adapter

        val list = listOf(
            Highlights("","highlight1"),
            Highlights("","highlight2"),
            Highlights("","highlight3"),
            Highlights("","highlight1"),
            Highlights("","highlight2"),
            Highlights("","highlight3"),
            Highlights("","highlight1"),
            Highlights("","highlight2"),
            Highlights("","highlight3"),
        )

        adapter.submitList(list)
    }

    private fun init() = with(binding) {
        val adapter = ViewPagerAdapter(activity as FragmentActivity, fList)
        viewPager.adapter= adapter
        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            tab.text = tList[position]
        }.attach()
    }



    companion object {
          @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}