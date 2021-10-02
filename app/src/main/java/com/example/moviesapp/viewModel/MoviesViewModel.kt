package com.example.moviesapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.model.MoviesModel
import com.example.moviesapp.repository.MyRepository
import com.example.moviesapp.utils.MyResponse
import kotlinx.coroutines.launch
import java.lang.Exception

class MoviesViewModel : ViewModel() {

    private val repository: MyRepository = MyRepository()
    private val moviesMutableLiveData: MutableLiveData<MyResponse<MoviesModel>> = MutableLiveData()
    val moviesLiveData = moviesMutableLiveData


    fun fetchMoviesList(offset: Int) {
        viewModelScope.launch {
            try {
                val response = repository.getMoviesList(
                    type = "all",
                    offset = offset,
                    order = "by-opening-date",
                    apiKey = "vwFvDpnoOa8cQx1g0DCy140hnyDvdR0i"
                )
                if (response.isSuccessful) {
                    moviesLiveData.postValue(MyResponse.Success(response.body()))
                } else
                    moviesLiveData.postValue(MyResponse.Error(response.message()))
            } catch (e: Exception) {
                moviesLiveData.postValue(MyResponse.Error(e.message))
            }


        }
    }
}