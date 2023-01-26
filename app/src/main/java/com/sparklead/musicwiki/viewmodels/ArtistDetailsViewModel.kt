package com.sparklead.musicwiki.viewmodels

import android.util.Log
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sparklead.musicwiki.model.artistInfoModel.ArtistInfoDataClass
import com.sparklead.musicwiki.model.artistTopAlbumModel.ArtistTopAlbumDataClass
import com.sparklead.musicwiki.model.artistTopTrackModel.ArtistTrackDataClass
import com.sparklead.musicwiki.repositories.ArtistDetailsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

class ArtistDetailsViewModel(private val artistDetailsRepository : ArtistDetailsRepository = ArtistDetailsRepository() ) : ViewModel() ,Observable {

    var artistName = MutableLiveData<String>()
    var artistDetail = MutableLiveData<ArtistInfoDataClass>()
    var artistAlbum = MutableLiveData<ArtistTopAlbumDataClass>()
    var artistTrack = MutableLiveData<ArtistTrackDataClass>()

    fun getArtistDetail(artist: String): MutableLiveData<ArtistInfoDataClass> {

        CoroutineScope(Dispatchers.IO).launch {
            val result = artistDetailsRepository.getArtistInfo(artist = artist)
            if (result.body() != null) {
                artistDetail.postValue(result.body())
            } else {
                Log.d("failed artistDetail", "nulls")
            }
        }
        return artistDetail
    }

    fun getArtistTopAlbum(artist: String): MutableLiveData<ArtistTopAlbumDataClass> {

        CoroutineScope(Dispatchers.IO).launch {
            val result = artistDetailsRepository.getArtistAlbum(artist)
            if (result.body() != null) {
                artistAlbum.postValue(result.body())
            } else {
                Log.d("failed artistTopAlbum", "nulls")
            }
        }
        return artistAlbum
    }

    fun getArtistTopTrack(artist: String): MutableLiveData<ArtistTrackDataClass> {

        CoroutineScope(Dispatchers.IO).launch {
            val result = artistDetailsRepository.getArtistTracks(artist)
            if (result.body() != null) {
                artistTrack.postValue(result.body())
            } else {
                Log.d("failed artistTopTrack", "nulls")
            }
        }
        return artistTrack
    }

    fun countViews(count: Long): String {
        val array = arrayOf(' ', 'k', 'M', 'B', 'T', 'P', 'E')
        val value = floor(log10(count.toDouble())).toInt()
        val base = value / 3
        if (value >= 3 && base < array.size) {
            return DecimalFormat("#0.0").format(count / 10.0.pow((base * 3).toDouble())) + array[base]
        } else {
            return DecimalFormat("#,##0").format(count)
        }
    }




    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        TODO("Not yet implemented")
    }
}