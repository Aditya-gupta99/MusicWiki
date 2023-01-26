package com.sparklead.musicwiki.model.artistTopTrackModel

import com.google.gson.annotations.SerializedName

data class Track(
    @SerializedName("@attr")
    val attr: AttrX,
    val artist: Artist,
    val image: List<Image>,
    val listeners: String,
    val mbid: String,
    var name: String,
    val playcount: String,
    val streamable: String,
    val url: String
)
