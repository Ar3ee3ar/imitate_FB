package com.clicknext.kmutnb.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.clicknext.kmutnb.R
import com.clicknext.kmutnb.databinding.FragmentPage2Binding
import com.clicknext.kmutnb.feature.adapter.FeedAdapter

class Page2Fragment: Fragment() {
    private lateinit var  binding : FragmentPage2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_page_2,container,false)
        return binding.root
    }
}