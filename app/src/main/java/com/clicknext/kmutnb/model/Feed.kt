package com.clicknext.kmutnb.model

data class Feed(
    var imageUrl : String = "",
    var name: String = "",
    var date: String = "",
    var detail: String = "",
    var isLike: Boolean = false,
    var likeCount: String = "",
    var commentCount: String = ""
)