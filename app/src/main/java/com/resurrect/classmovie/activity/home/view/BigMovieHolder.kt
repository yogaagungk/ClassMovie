package com.resurrect.classmovie.activity.home.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.resurrect.classmovie.activity.home.store.BigMovieItem
import com.resurrect.classmovie.activity.home.store.MainItem
import com.resurrect.classmovie.core.listener.OnItemClickListener
import com.resurrect.classmovie.core.view.BaseHolder
import com.resurrect.classmovie.model.MovieList.Movie
import com.resurrect.classmovie.core.api.ApiConstant
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_row_item_big.view.*

/**
 * Created by yogaagungk on 12/02/18.
 */
class BigMovieHolder(itemView: View, listener : OnItemClickListener) : BaseHolder(itemView) {

    private val IMG_URL = ApiConstant.IMG_URL
    private val SMALL_POSTER_SIZE = "w342/"

    init {
        setupView(itemView, listener)
    }

    override fun setupView(view: View, mListener: OnItemClickListener) {
        view.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val position = adapterPosition
                if (position!= RecyclerView.NO_POSITION){
                    mListener.onItemClick(position)
                }
            }
        })
    }

    override fun bind(data: MainItem) {
        val movie = data as BigMovieItem
        itemView.txt_title.text = movie.movie?.originalTitle
        Picasso.with(itemView.context).load(IMG_URL + SMALL_POSTER_SIZE + movie.movie?.posterPath).fit()
                .centerCrop()
                .into(itemView.img_photo)
    }
}