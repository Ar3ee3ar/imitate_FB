package com.clicknext.kmutnb.feature

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.clicknext.kmutnb.model.Feed

class FeedViewModel : ViewModel(){
    val feed = MutableLiveData<ArrayList<Feed>>()
    val feeds = ArrayList<Feed>()

    fun addFeedModel(
        imageUrl : String = "",
        name: String = "",
        date: String = "",
        detail: String = "",
        isLike: Boolean = false,
        likeCount: String = "",
        commentCount: String = ""
    ){
        feeds.add(Feed(imageUrl, name, date, detail, isLike, likeCount, commentCount))
    }

    fun setValueFeeds(){
        feed.value = feeds
    }

    fun setLike(position: Int) {
        feeds[position].isLike = feeds[position].isLike != true
        if(feeds[position].isLike){
            feeds[position].likeCount = "${feeds[position].likeCount.toInt() + 1}"
        }else {
            feeds[position].likeCount = "${feeds[position].likeCount.toInt() - 1}"
        }
        feed.value = feeds
    }
}