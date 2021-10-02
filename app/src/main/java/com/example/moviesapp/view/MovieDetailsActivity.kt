package com.example.moviesapp.view

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.moviesapp.model.Result
import com.example.moviesapp.R
import com.example.moviesapp.utils.AppConstants
import com.example.moviesapp.databinding.ActivityMovieDetailsBinding
import java.lang.StringBuilder

class MovieDetailsActivity: AppCompatActivity() {
    lateinit var binding : ActivityMovieDetailsBinding;
    lateinit var movie : Result

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root);
        initialise();
    }

    private fun initialise() {
        movie = intent.getParcelableExtra<Result>(AppConstants.movie) as Result
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.movieNameTv.text = movie.displayTitle
        binding.publishedDateTv.text = movie.publicationDate
        val director = StringBuilder(resources.getString(R.string.By) + " "+ movie.byline)
        binding.directedByTv.text = director.toString()
        binding.headlineTv.text = movie.headline
        binding.summaryTv.text = movie.summaryShort
        binding.suggestedLinkTv.text = movie.link?.suggestedLinkText
        binding.linkTv.text = movie.link?.url

        Glide.with(this)
            .load(movie.multimedia?.src)
            .fitCenter()
            .into(
                binding.movieImgView
            )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            onBackPressed()
        return super.onOptionsItemSelected(item)
    }

}