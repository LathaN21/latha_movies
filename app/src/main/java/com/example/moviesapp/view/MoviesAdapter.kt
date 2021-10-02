package com.example.moviesapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.model.Result
import com.example.moviesapp.utils.ItemClickListener
import com.example.moviesapp.databinding.ItemMovieBinding

class MoviesAdapter(context: Context, movies: List<Result>,clickInterface : ItemClickListener<Int>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var movies: List<Result> = movies;
    var context: Context = context;
    var clickInterface : ItemClickListener<Int> = clickInterface;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemMovieDetailsBinding: ItemMovieBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(itemMovieDetailsBinding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, i: Int) {

        val itemViewHolder: ItemViewHolder = holder as ItemViewHolder
        itemViewHolder.itemBinding.movieNameTv.text = movies[i].displayTitle

        val url = movies[i].multimedia?.src
        Glide.with(context)
            .load(url)
            .fitCenter()
            .into(
                itemViewHolder.itemBinding.movieImgView
            )
        itemViewHolder.itemBinding.moviesLayout.setOnClickListener {
            clickInterface.onItemClick(i)
        }
    }

    class ItemViewHolder(binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        var itemBinding: ItemMovieBinding = binding
    }

}