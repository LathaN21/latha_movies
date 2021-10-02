package com.example.moviesapp.utils

class AppConstants {
    companion object {
        const val contentType: String = "Content-Type: application/json;charset=UTF-8"
        const val baseUrl: String = "https://api.nytimes.com/"
        const val movieListUrl: String = "svc/movies/v2/reviews/{type}.json"
        const val type: String = "type"
        const val offset: String = "offset"
        const val order: String = "order"
        const val apiKey: String = "api-key"
        const val movie: String = "movie"
    }
}