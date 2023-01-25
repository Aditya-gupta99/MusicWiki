package com.sparklead.musicwiki.viewmodels

import android.util.Log
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sparklead.musicwiki.`interface`.RetrofitInterface
import com.sparklead.musicwiki.model.GenreDetails.GenreDetailModel
import com.sparklead.musicwiki.model.albumModel.AlbumDataClass
import com.sparklead.musicwiki.model.artistModel.ArtistDataClass
import com.sparklead.musicwiki.model.trackModel.TrackDataClass
import com.sparklead.musicwiki.repositories.GenreDetailsRepository
import com.sparklead.musicwiki.utils.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GenreDetailsViewModel(private val genreDetails : GenreDetailsRepository = GenreDetailsRepository()) : ViewModel() ,Observable{

    var result = MutableLiveData<GenreDetailModel>()
    var topAlbum = MutableLiveData<AlbumDataClass>()
    var tagName = MutableLiveData<String>()
    var topArtist = MutableLiveData<ArtistDataClass>()
    var topTracks = MutableLiveData<TrackDataClass>()


    fun setTagName(tag: String) {
        tagName.value = tag
        Log.e("newTag",tagName.value.toString())
    }

    fun getDetails(tag : String) :MutableLiveData<GenreDetailModel>{

        CoroutineScope(Dispatchers.IO).launch {
            result.postValue(genreDetails.getGenreDetails(tag).body())
            if (result.value != null) {
                Log.d("tagInfo", result.value.toString())
            } else {
                Log.d("failed tags", "nulls")
            }
        }
        return result
    }

    fun getAlbum(tag : String) : MutableLiveData<AlbumDataClass>{
        CoroutineScope(Dispatchers.IO).launch {
            val result = genreDetails.getAlbums(tag)
            if (result.body() != null) {
                topAlbum.postValue(result.body())
                Log.d("tagInfo", result.body().toString())
            } else {
                Log.d("failed tags", "nulls")
            }
        }
        return topAlbum
    }

    fun getArtist(tag : String) : MutableLiveData<ArtistDataClass>{
        CoroutineScope(Dispatchers.IO).launch {
            val result = genreDetails.getArtist(tag)
            if (result.body() != null) {
                topArtist.postValue(result.body())
                Log.d("tagInfo", result.body().toString())
            } else {
                Log.d("failed tags", "nulls")
            }
        }
        return topArtist
    }

    fun getTrack(tag : String) : MutableLiveData<TrackDataClass>{
        CoroutineScope(Dispatchers.IO).launch {
            val result = genreDetails.getTrack(tag)
            if (result.body() != null) {
                topTracks.postValue(result.body())
                Log.d("tagInfo", result.body().toString())
            } else {
                Log.d("failed tags", "nulls")
            }
        }
        return topTracks
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}