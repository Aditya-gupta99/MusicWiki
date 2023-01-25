package com.sparklead.musicwiki.viewmodels

import android.util.Log
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sparklead.musicwiki.model.tagDataClass.Tag
import com.sparklead.musicwiki.repositories.GenreRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GenreViewModel(private val genreRepository: GenreRepository = GenreRepository()) :
    ViewModel(),
    Observable {

    var _tagList = MutableLiveData<String>()
    var tagList: List<Tag> =  arrayListOf()

    fun getGenreTag() {

        CoroutineScope(Dispatchers.IO).launch {
            val result = genreRepository.getTopTags()
            if (result.body() != null) {
                tagList = result.body()!!.toptags.tag
                _tagList.postValue("true")
            } else {
                Log.d("failed tags", "nulls")
            }
        }

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}