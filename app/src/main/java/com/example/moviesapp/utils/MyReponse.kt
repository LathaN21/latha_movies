package com.example.moviesapp.utils

import com.example.moviesapp.model.MoviesModel
import okhttp3.ResponseBody

sealed class MyResponse<out T : Any> {
    data class Success<out T : Any>(val data: MoviesModel?) : MyResponse<T>()
    data class Error(val exception: String?) : MyResponse<Nothing>()
}