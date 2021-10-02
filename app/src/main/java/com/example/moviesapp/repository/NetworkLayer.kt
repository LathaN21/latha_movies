package com.example.moviesapp.repository

import com.example.moviesapp.utils.AppConstants
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkLayer {
    var apiInterface: ApiInterface
init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(AppConstants.baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()

   apiInterface = retrofit.create(ApiInterface::class.java)
}

}