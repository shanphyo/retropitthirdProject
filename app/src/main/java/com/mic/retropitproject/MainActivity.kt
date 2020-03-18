package com.mic.retropitproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.mic.retropitproject.Api.ApiInterface
import com.mic.retropitproject.model.Article
import com.mic.retropitproject.model.News
import com.mic.webservice.Adapter.RecyclerData
import com.mic.webservice.Adapter.TitleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() ,RecyclerData{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getTitleone()
    }

    fun getTitleone(){

        val BaseUrl="http://newsapi.org/v2/"
        var retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var retrofitService=retrofit.create(ApiInterface::class.java)
        var apiCall=retrofitService.getNews("us","business","57a2e15d1f48416d986fa6e25771ee9a")
        apiCall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {

            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                var datalist=response.body()?.articles
                var titleAdapt= datalist?.let { TitleAdapter(it,this@MainActivity) }
                recycle .layoutManager = LinearLayoutManager(applicationContext)
                recycle.adapter = titleAdapt
                Log.d("Reponse>>>>",datalist.toString())
            }


        })

    }

    override fun onFunClick(vote:Article) {
        val intent=Intent(this@MainActivity,DetailPage::class.java)
        intent.putExtra("detail",vote.content.toString())
        intent.putExtra("title",vote.title.toString())
        intent.putExtra("image",vote.urlToImage)
        startActivity(intent)

    }
}
