package com.resurrect.classmovie.activity.home.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.resurrect.classmovie.activity.home.store.MainItem
import com.resurrect.classmovie.activity.home.store.MovieItem
import com.resurrect.classmovie.core.listener.OnItemClickListener
import com.resurrect.classmovie.core.view.BaseHolder
import com.resurrect.classmovie.model.MovieList.Movie
import kotlinx.android.synthetic.main.movie_row_item.view.*

/**
 * Created by yogaagungk on 10/02/18.
 */
class MovieHolder(itemView : View, listener : OnItemClickListener) : BaseHolder(itemView) {

    init {
        setupView(itemView, listener)
    }

    override fun setupView(view : View, mListener: OnItemClickListener){
        view.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val position = adapterPosition
                if (position!= RecyclerView.NO_POSITION){
                    mListener.onItemClick(position)
                }
            }
        })
    }

    override fun bind(data : MainItem){
        val movie = data as MovieItem
        itemView.txt_title.text = movie.movie?.originalTitle
        itemView.txt_release_date.text = movie.movie?.releaseDate
    }
}