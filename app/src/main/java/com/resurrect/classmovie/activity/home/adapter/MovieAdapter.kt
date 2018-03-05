package com.resurrect.classmovie.activity.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.resurrect.classmovie.R
import com.resurrect.classmovie.activity.home.store.MainItem
import com.resurrect.classmovie.activity.home.view.BigMovieHolder
import com.resurrect.classmovie.activity.home.view.MovieHolder
import com.resurrect.classmovie.core.listener.OnItemClickListener
import com.resurrect.classmovie.core.view.BaseHolder
import com.resurrect.classmovie.model.MovieList.Movie

/**
 * Created by yogaagungk on 10/02/18.
 */
class MovieAdapter(private val list : ArrayList<MainItem>) : RecyclerView.Adapter<BaseHolder>(){

    private var mListener : OnItemClickListener? = null

    override fun onBindViewHolder(holder: BaseHolder?, position: Int) {
        holder?.bind(list.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseHolder? {
        val view = LayoutInflater.from(parent?.context).inflate(viewType, parent, false)

        return if (viewType == R.layout.movie_row_item_big) BigMovieHolder(view, mListener!!)
        else MovieHolder(view, mListener!!)
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return list.get(position).getType()
    }

    fun setOnClickListener(listener : OnItemClickListener){
        mListener = listener
    }
}