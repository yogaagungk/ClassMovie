package com.resurrect.classmovie.model.MovieDetail

import com.google.gson.annotations.SerializedName

class BelongsToCollection {

    @SerializedName("backdrop_path")
    var backdropPath: String? = null
    @SerializedName("id")
    var id: Long? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("poster_path")
    var posterPath: String? = null

}
