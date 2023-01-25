package com.sparklead.musicwiki.utils

import com.sparklead.musicwiki.`interface`.RetrofitInterface
import com.sparklead.musicwiki.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {

        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }

        val genreTag : RetrofitInterface by lazy{
            retrofit.create(RetrofitInterface::class.java)
        }
        val genreDetails : RetrofitInterface by lazy{
            retrofit.create(RetrofitInterface::class.java)
        }
        val albumDetails : RetrofitInterface by lazy {
            retrofit.create(RetrofitInterface::class.java)
        }
        val artistDetails : RetrofitInterface by lazy {
            retrofit.create(RetrofitInterface::class.java)
        }
        val trackDetails : RetrofitInterface by lazy {
            retrofit.create(RetrofitInterface::class.java)
        }
        val albumDetailsPage : RetrofitInterface by lazy {
            retrofit.create(RetrofitInterface::class.java)
        }
    }
}