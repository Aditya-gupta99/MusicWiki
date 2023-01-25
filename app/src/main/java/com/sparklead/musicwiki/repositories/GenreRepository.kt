package com.sparklead.musicwiki.repositories

import com.sparklead.musicwiki.`interface`.RetrofitInterface
import com.sparklead.musicwiki.utils.Constants.API_KEY
import com.sparklead.musicwiki.utils.RetrofitInstance

class GenreRepository(){
    suspend fun getTopTags() = RetrofitInstance.genreTag.getTopTags(API_KEY,"json")
}