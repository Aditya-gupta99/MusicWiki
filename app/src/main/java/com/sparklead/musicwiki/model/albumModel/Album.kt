package com.sparklead.musicwiki.model.albumModel

data class Album(
    var artist: Artist,
    val image: List<Image>,
    val mbid: String,
    var name: String,
    val url: String
)
