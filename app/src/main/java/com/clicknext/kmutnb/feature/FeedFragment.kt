package com.clicknext.kmutnb.feature

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.clicknext.kmutnb.R
import com.clicknext.kmutnb.databinding.FragmentFeedBinding
import com.clicknext.kmutnb.feature.adapter.FeedAdapter
import com.clicknext.kmutnb.model.Feed

class FeedFragment : Fragment() {

    private lateinit var  binding : FragmentFeedBinding
    private var viewModel: FeedViewModel? = null
    private var feedAdapter: FeedAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_feed,container,false)
        initViewModel()
        initFeedModel()
        return binding.root
    }

    private fun initFeedModel() {
        viewModel?.addFeedModel("https://sv1.picz.in.th/images/2019/11/28/iSVfcl.th.jpg\n",
        "a",
        "22 Jan 2022 14:47PM",
        "Yeah!",
        false,
        "352",
        "12")
        viewModel?.addFeedModel("https://i.pinimg.com/originals/70/ea/2a/70ea2a8145f70c895157a92826ef3d53.jpg",
            "b",
            "22 Jan 2022 14:47PM",
            "Yeah!",
            false,
            "352",
            "12")
        viewModel?.addFeedModel("https://xn--72c9aoai7a4bxcd6c7l.com/wp-content/uploads/2019/04/%E0%B8%A0%E0%B8%B2%E0%B8%9E%E0%B8%9E%E0%B8%B7%E0%B9%89%E0%B8%99%E0%B8%AB%E0%B8%A5%E0%B8%B1%E0%B8%87%E0%B8%94%E0%B8%AD%E0%B8%81%E0%B9%84%E0%B8%A1%E0%B9%89-6.jpg",
            "c",
            "22 Jan 2022 14:47PM",
            "Yeah!",
            false,
            "352",
            "12")
        viewModel?.addFeedModel("https://xn--72c9aoai7a4bxcd6c7l.com/wp-content/uploads/2019/04/%E0%B8%A0%E0%B8%B2%E0%B8%9E%E0%B8%9E%E0%B8%B7%E0%B9%89%E0%B8%99%E0%B8%AB%E0%B8%A5%E0%B8%B1%E0%B8%87%E0%B8%94%E0%B8%AD%E0%B8%81%E0%B9%84%E0%B8%A1%E0%B9%89-10.jpg",
            "d",
            "22 Jan 2022 14:47PM",
            "Yeah!",
            false,
            "352",
            "12")
        viewModel?.addFeedModel("https://lifestyle.campus-star.com/app/uploads/2016/11/flowers-nice-15.jpg",
            "e",
            "22 Jan 2022 14:47PM",
            "Yeah!",
            false,
            "352",
            "12")
        viewModel?.addFeedModel("C:/Users/acer/Downloads/user.png",
            "f",
            "22 Jan 2022 14:47PM",
            "Yeah!",
            false,
            "352",
            "12")
        viewModel?.addFeedModel("https://img.lovepik.com/free-png/20210922/lovepik-cartoon-flower-png-image_401141870_wh1200.png",
            "g",
            "22 Jan 2022 14:47PM",
            "Yeah!",
            false,
            "352",
            "12")
        viewModel?.addFeedModel("C:\\Users\\acer\\Downloads\\user",
            "h",
            "22 Jan 2022 14:47PM",
            "Yeah!",
            false,
            "352",
            "12")
        viewModel?.addFeedModel("C:\\Users\\acer\\Downloads\\user",
            "i",
            "22 Jan 2022 14:47PM",
            "Yeah!",
            false,
            "352",
            "12")
        viewModel?.addFeedModel("C:\\Users\\acer\\Downloads\\user",
            "j",
            "22 Jan 2022 14:47PM",
            "Yeah!",
            false,
            "352",
            "12")
        viewModel?.setValueFeeds()
    }

    private fun initViewModel() {
        viewModel = FeedViewModel()
        viewModel?.feed?.observe(viewLifecycleOwner, {
            setFeedAdapter(it)
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setFeedAdapter(feeds: ArrayList<Feed>) {
        feedAdapter = FeedAdapter(feeds,object:FeedAdapter.OnItemClickListerner{
            override fun onClickLike(position: Int) {
                viewModel?.setLike(position)
            }

            override fun onItemClick() {
                findNavController().navigate(R.id.action_feedFragment_to_page2Fragment)
            }
        })
        binding.adapter = feedAdapter
        binding.adapter?.notifyDataSetChanged()
    }
}