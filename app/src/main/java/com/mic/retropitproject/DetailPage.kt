package com.mic.retropitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_page.*

class DetailPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)
        var body=intent.getStringExtra("detail")
        var title=intent.getStringExtra("title")
        var img=intent.getStringExtra("image")
        txt_tit.setText(title)
        txt_detail.setText("    "+body)
        Glide.with(applicationContext)
            .load(img)   //parameter passing
            .placeholder(R.drawable.ic_autorenew_black_24dp)  //image load
            .into(img_image)   //id

    }
}
