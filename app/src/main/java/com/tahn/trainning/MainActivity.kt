package com.tahn.trainning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tahn.trainning.adapter.MovieAdapter
import com.tahn.trainning.api.ApiService
import com.tahn.trainning.api.RetrofitClient
import com.tahn.trainning.model.Movie
import com.tahn.trainning.model.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var listMovie : ArrayList<Movie>? = null
    private var adapterMovie : MovieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callApi()
        bindRecycleView()

    }

    private fun bindRecycleView() {
        adapterMovie = MovieAdapter(applicationContext)
        findViewById<RecyclerView>(R.id.rvMovie).layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        findViewById<RecyclerView>(R.id.rvMovie).adapter = adapterMovie
    }

    private fun callApi() {
        val client = RetrofitClient()
        val api = client.getClient().create(ApiService::class.java)
        val callback = api.getMovieNowPlaying("a07e22bc18f5cb106bfe4cc1f83ad8ed")

        callback.enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                if (response.isSuccessful) {
                    listMovie = response.body()?.results
                    if(listMovie != null){
                        adapterMovie?.addList(listMovie!!)
                    }
                }
            }
        })
    }
}
