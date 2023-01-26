package com.sparklead.musicwiki.model.artistTopTrackModel

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("#text")
    val text: String,
    val size: String
)