package com.sparklead.musicwiki.repositories

import com.sparklead.musicwiki.utils.RetrofitInstance

class AlbumDetailsRepository() {
    suspend fun getAlbumDetails(artist : String ,album : String ) = RetrofitInstance.albumDetailsPage.getAlbumDetail(artist = artist, album = album)
}