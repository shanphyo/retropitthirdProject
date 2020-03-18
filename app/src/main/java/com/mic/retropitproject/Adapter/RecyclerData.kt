package com.mic.webservice.Adapter

import com.mic.retropitproject.model.Article
import com.mic.retropitproject.model.News

interface RecyclerData{
    fun onFunClick(vote:Article)
}