package com.sparklead.musicwiki.repositories

import com.sparklead.musicwiki.utils.RetrofitInstance

class ArtistDetailsRepository() {

    suspend fun getArtistAlbum(artist : String) = RetrofitInstance.artistAlbums.getTopArtistAlbum(artist)

    suspend fun getArtistTracks(artist: String) = RetrofitInstance.artistTrack.getTopArtistTrack(artist)

    suspend fun getArtistInfo(artist: String) = RetrofitInstance.artistInfo.getArtistInfo(artist)

}