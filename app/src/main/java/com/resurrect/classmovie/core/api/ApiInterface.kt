package com.resurrect.classmovie.core.api

import com.resurrect.classmovie.model.MovieList.MovieList
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

/**
 * Created by yogaagungk on 10/02/18.
 */
interface ApiInterface {

    @GET("discover/movie")
    fun getAllMovie(@Query("page") page: Int, @Query("api_key") key : String) : Call<MovieList>
}