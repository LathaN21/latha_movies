package com.example.moviesapp.repository

import com.example.moviesapp.model.MoviesModel
import retrofit2.Response


class MyRepository {

    suspend fun getMoviesList(
        type: String,
        offset: Int,
        order: String,
        apiKey: String,
    ): Response<MoviesModel> = NetworkLayer.apiInterface.getMoviesList(type, offset, order, apiKey)

}