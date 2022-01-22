package com.clicknext.kmutnb.feature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.clicknext.kmutnb.R
import com.clicknext.kmutnb.databinding.ItemFeedBinding
import com.clicknext.kmutnb.model.Feed

class FeedAdapter(private val feeds: ArrayList<Feed>? = ArrayList(), private val listerner:OnItemClickListerner) : RecyclerView.Adapter<FeedAdapter.ViewHolder>() { // loop size ArrayList to create item_feed

    interface  OnItemClickListerner{
        fun onClickLike(position: Int)
        fun onItemClick()
    }

    inner class ViewHolder(private val binding: ItemFeedBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindingView(position : Int){
            binding.model = feeds?.get(position) ?: Feed()
            binding.position = position // for further used
            binding.listener = listerner
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent
                .context),R.layout.item_feed,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindingView(position)
    }

    override fun getItemCount(): Int {
        return if(feeds.isNullOrEmpty()) 0 else feeds.size
    }
}