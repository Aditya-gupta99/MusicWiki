package com.sparklead.musicwiki.`interface`

import com.sparklead.musicwiki.model.GenreDetails.GenreDetailModel
import com.sparklead.musicwiki.model.albumDetailModel.AlbumDetailDataClass
import com.sparklead.musicwiki.model.albumModel.AlbumDataClass
import com.sparklead.musicwiki.model.artistModel.ArtistDataClass
import com.sparklead.musicwiki.model.tagDataClass.GenreTag
import com.sparklead.musicwiki.model.trackModel.TrackDataClass
import com.sparklead.musicwiki.utils.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("?method=tag.getTopTags")
     suspend fun getTopTags(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): Response<GenreTag>

    @GET("?method=tag.getinfo")
    suspend fun getTagInfo(
        @Query("tag") tag: String,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): Response<GenreDetailModel>

    @GET("?method=tag.gettopalbums")
    suspend fun getTopAlbum(
        @Query("tag") tag: String,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): Response<AlbumDataClass>

    @GET("?method=tag.gettopartists")
    suspend fun getTopArtist(
        @Query("tag") tag: String,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): Response<ArtistDataClass>

    @GET("?method=tag.gettoptracks")
    suspend fun getTopTrack(
        @Query("tag") tag: String,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = "json"
    ): Response<TrackDataClass>

    @GET("?method=album.getinfo")
    suspend fun getAlbumDetail(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("artist") artist: String,
        @Query("album") album: String,
        @Query("format") format: String = "json"
    ): Response<AlbumDetailDataClass>

}