package com.example.mobileapplication11.home.homePosts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileapplication11.adapters.HighlightsAdapter
import com.example.mobileapplication11.adapters.PostsAdapter
import com.example.mobileapplication11.databinding.FragmentHomePostsBinding
import com.example.mobileapplication11.models.Highlights
import com.example.mobileapplication11.models.Post

class HomePostsFragment : Fragment() {

    private lateinit var binding : FragmentHomePostsBinding
    private lateinit var postsAdapter: PostsAdapter
    private lateinit var storiesAdapter: HighlightsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomePostsBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPostsRcView()
        initStoriesRcView()
    }

    private fun initStoriesRcView() = with(binding){
        rvStories.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        storiesAdapter = HighlightsAdapter()
        rvStories.adapter = storiesAdapter
        val list = listOf(
            Highlights("","friend1"),
            Highlights("","friend2"),
            Highlights("","friend3"),
            Highlights("","friend4"),
            Highlights("","friend1"),
            Highlights("","friend2"),
            Highlights("","friend3"),
            Highlights("","friend4"),
            )
        storiesAdapter.submitList(list)
    }

    private fun initPostsRcView() = with(binding){
        rvHomePosts.layoutManager = LinearLayoutManager(activity)
        postsAdapter = PostsAdapter()
        rvHomePosts.adapter = postsAdapter

        val list = listOf(
            Post("","user293487", "London, England",""),
            Post("","user51", "Paris, France",""),
            Post("","kjawbhv", "Tbilisi, Georgia",""),
            Post("","sfljb", "London, England",""),
            Post("","user293487", "London, England",""),
            Post("","user51", "Paris, France",""),
            Post("","kjawbhv", "Tbilisi, Georgia",""),
            Post("","sfljb", "London, England",""),
            Post("","user293487", "London, England",""),
            Post("","user51", "Paris, France",""),
            Post("","kjawbhv", "Tbilisi, Georgia",""),
            Post("","sfljb", "London, England",""),
        )

        postsAdapter.submitList(list)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomePostsFragment()
    }
}