package com.resurrect.classmovie.core.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.resurrect.classmovie.activity.home.store.MainItem
import com.resurrect.classmovie.core.listener.OnItemClickListener
import com.resurrect.classmovie.model.MovieList.Movie

/**
 * Created by yogaagungk on 12/02/18.
 */
abstract class BaseHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    abstract fun setupView(view : View, mListener: OnItemClickListener)
    abstract fun bind(data : MainItem)
}