package com.resurrect.classmovie.model.MovieList

import com.google.gson.annotations.SerializedName

class MovieList {

    @SerializedName("page")
    var page: Long? = null
    @SerializedName("results")
    var results: List<Movie>? = null
    @SerializedName("total_pages")
    var totalPages: Long? = null
    @SerializedName("total_results")
    var totalResults: Long? = null

}
