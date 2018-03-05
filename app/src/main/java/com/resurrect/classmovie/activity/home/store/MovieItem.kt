package com.resurrect.classmovie.activity.home.store

import com.resurrect.classmovie.R
import com.resurrect.classmovie.model.MovieList.Movie

/**
 * Created by yogaagungk on 12/02/18.
 */
class MovieItem(movi : Movie) : MainItem {

    var movie : Movie? = null

    init {
        movie = movi
    }

    override fun getType(): Int {
        return R.layout.movie_row_item
    }
}