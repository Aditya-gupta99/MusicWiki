package com.sparklead.musicwiki.model.artistInfoModel

data class Bio(
    val content: String,
    val links: Links,
    val published: String,
    val summary: String
)
