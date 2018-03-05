package com.resurrect.classmovie.activity.home.util

import android.util.Log
import com.resurrect.classmovie.activity.home.store.BigMovieItem
import com.resurrect.classmovie.activity.home.store.MainItem
import com.resurrect.classmovie.activity.home.store.MovieItem
import com.resurrect.classmovie.model.MovieList.Movie

/**
 * Created by yogaagungk on 12/02/18.
 */
object StoreToMovie {
    fun getMovieItemList(data : ArrayList<Movie>): ArrayList<MainItem> {
        var rslt = ArrayList<MainItem>()

        var pos = 0
        for (movi in data){
            Log.d("Data",rslt.size.toString())
            rslt.add(pos,itemMainItem(movi,pos))
            pos++
        }
        return rslt
    }

    fun itemMainItem(data : Movie, pos : Int): MainItem {
        return if (pos%4 == 0) BigMovieItem(data)
        else MovieItem(data)
    }
}