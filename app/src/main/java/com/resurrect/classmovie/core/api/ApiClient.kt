package com.resurrect.classmovie.core.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import com.resurrect.classmovie.core.api.ApiConstant

/**
 * Created by yogaagungk on 10/02/18.
 */
class ApiClient {
    val BASE_URL = ApiConstant.BASE_URL
    private var retrofit : Retrofit? = null

    fun getClient(): Retrofit{
        if (retrofit==null){
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit!!
    }
}