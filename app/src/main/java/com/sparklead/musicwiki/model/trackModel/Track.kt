package com.sparklead.musicwiki.model.trackModel

data class Track(
    var artist: Artist,
    val duration: String,
    val image: List<Image>,
    val mbid: String,
    var name: String,
    val url: String
)
