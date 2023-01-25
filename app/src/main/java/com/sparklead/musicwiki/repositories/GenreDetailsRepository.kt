package com.sparklead.musicwiki.repositories

import com.sparklead.musicwiki.utils.RetrofitInstance

class GenreDetailsRepository() {
    suspend fun getGenreDetails(key : String) = RetrofitInstance.genreDetails.getTagInfo(key)

    suspend fun getAlbums(key : String) = RetrofitInstance.albumDetails.getTopAlbum(key)

    suspend fun getArtist(key : String) = RetrofitInstance.artistDetails.getTopArtist(key)

    suspend fun getTrack(key : String) = RetrofitInstance.trackDetails.getTopTrack(key)
}