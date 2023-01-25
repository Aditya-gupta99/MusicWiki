package com.sparklead.musicwiki.model.artistModel

data class Artist(
    val image: List<Image>,
    val mbid: String,
    var name: String,
    val streamable: String,
    val url: String
)
