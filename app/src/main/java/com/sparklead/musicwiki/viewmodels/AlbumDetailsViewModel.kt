package com.sparklead.musicwiki.viewmodels

import android.util.Log
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sparklead.musicwiki.model.albumDetailModel.AlbumDetailDataClass
import com.sparklead.musicwiki.repositories.AlbumDetailsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlbumDetailsViewModel(private val albumRepository : AlbumDetailsRepository = AlbumDetailsRepository()) : ViewModel(),Observable{

    var albumDetail = MutableLiveData<AlbumDetailDataClass>()


    fun getAlbumDetail(artist: String, album: String): MutableLiveData<AlbumDetailDataClass> {

        CoroutineScope(Dispatchers.IO).launch {
            val result = albumRepository.getAlbumDetails(artist = artist, album = album)
            if (result.body() != null) {
                albumDetail.postValue(result.body())
                Log.d("albumDetail", albumDetail.value.toString())
            } else {
                Log.d("failed albumDetail", "nulls")
            }
        }
        return albumDetail
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}