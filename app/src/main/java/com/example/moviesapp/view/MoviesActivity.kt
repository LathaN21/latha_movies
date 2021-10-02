package com.example.moviesapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.model.MoviesModel
import com.example.moviesapp.model.Result
import com.example.moviesapp.utils.AppConstants
import com.example.moviesapp.utils.ItemClickListener
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.utils.MyResponse
import com.example.moviesapp.viewModel.MoviesViewModel

class MoviesActivity : AppCompatActivity(), ItemClickListener<Int> {
    lateinit var binding: ActivityMainBinding;
    lateinit var viewModel: MoviesViewModel
    var moviesList: MoviesModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);
        initialise();
    }

    private fun initialise() {
        viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        binding.progressDialog.visibility = VISIBLE
        viewModel.fetchMoviesList(20)
        viewModel.moviesLiveData.observe(this, Observer { response ->
            binding.progressDialog.visibility = GONE
            when (response) {
                is MyResponse.Success -> {
                    if (response.data != null) {
                        moviesList = response.data
                        loadRecyclerView(moviesList!!)
                    }
                }
                is MyResponse.Error -> {
                    Toast.makeText(this,  response.exception, Toast.LENGTH_LONG).show()
                }
            }
        })

    }

    private fun loadRecyclerView(movies: MoviesModel) {
        binding.moviesRv.visibility = VISIBLE
        val moviesAdapter = MoviesAdapter(this, movies.results, this);
        val linearLayoutManager = LinearLayoutManager(this)
        binding.moviesRv.layoutManager = linearLayoutManager
        binding.moviesRv.adapter = moviesAdapter;
    }

    override fun onItemClick(i: Int) {
        val movie: Result? = moviesList?.results?.get(i)
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(AppConstants.movie, movie)
        startActivity(intent)
    }
}