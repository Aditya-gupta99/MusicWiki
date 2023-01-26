package com.sparklead.musicwiki.model.artistTopAlbumModel

data class Album(
    val artist: Artist,
    val image: List<Image>,
    val mbid: String,
    var name: String,
    val playcount: Int,
    val url: String
)
