package com.example.moviesapp.repository


import com.example.moviesapp.model.MoviesModel
import com.example.moviesapp.utils.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @Headers(AppConstants.contentType)
    @GET(AppConstants.movieListUrl)
    suspend fun getMoviesList(
        @Path(AppConstants.type) type: String,
        @Query(AppConstants.offset) offset: Int,
        @Query(AppConstants.order) order: String,
        @Query(AppConstants.apiKey) apiKey: String
    ): Response<MoviesModel>
}