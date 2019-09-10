package com.tahn.trainning

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.tahn.trainning.api.ApiService
import com.tahn.trainning.api.RetrofitClient
import com.tahn.trainning.model.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var client = RetrofitClient()
        var api = client.getClient().create(ApiService::class.java)
        var callback = api.getTopRatedMovies("a07e22bc18f5cb106bfe4cc1f83ad8ed")

        callback.enqueue(object : Callback<MoviesResponse>{
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.d("tu_cao_nguyen", t.message.toString())
            }

            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                if(response.isSuccessful){
                    Log.d("tu_cao_nguyen", response.body().toString())
                }
            }
        })
    }
}
