package com.resurrect.classmovie.activity.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.resurrect.classmovie.BuildConfig

import com.resurrect.classmovie.R
import com.resurrect.classmovie.activity.home.adapter.MovieAdapter
import com.resurrect.classmovie.activity.home.util.StoreToMovie
import com.resurrect.classmovie.core.api.ApiClient
import com.resurrect.classmovie.core.api.ApiInterface
import com.resurrect.classmovie.core.listener.OnItemClickListener
import com.resurrect.classmovie.core.util.Divider
import com.resurrect.classmovie.model.MovieList.Movie
import com.resurrect.classmovie.model.MovieList.MovieList
import kotlinx.android.synthetic.main.fragment_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieFragment() : Fragment() {

    var layoutManager : RecyclerView.LayoutManager? = null
    var adapter : MovieAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root = inflater!!.inflate(R.layout.fragment_movie, container, false) as ViewGroup

        return root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(activity)
        recycler_view.layoutManager = layoutManager

        val decoration = Divider(context)
        recycler_view.addItemDecoration(decoration)
        getMovie()

        activity.title = "Movie"
    }

    private fun getMovie(){
        val request = ApiClient().getClient().create(ApiInterface::class.java)
        val call : Call<MovieList> = request.getAllMovie(1, BuildConfig.API_KEY)
        call.enqueue(object : Callback<MovieList>{
            override fun onResponse(call: Call<MovieList>?, response: Response<MovieList>?) {
                var listMovie : ArrayList<Movie> = response?.body()?.results as ArrayList<Movie>
                Log.d("Sukses", "Get Data Berhasil")
                adapter = MovieAdapter(StoreToMovie.getMovieItemList(listMovie))
                recycler_view.adapter = adapter

                adapter!!.setOnClickListener(object : OnItemClickListener{
                    override fun onItemClick(position: Int) {
                        Toast.makeText(activity,listMovie.get(position).originalTitle,Toast.LENGTH_SHORT).show()
                        Log.e("Error", listMovie.get(position).originalTitle)
                    }
                })
                adapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<MovieList>?, t: Throwable?) {
                    Log.d("Error", t?.message)
            }
        })
    }
}