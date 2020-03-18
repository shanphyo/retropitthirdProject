package com.mic.retropitproject.model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)