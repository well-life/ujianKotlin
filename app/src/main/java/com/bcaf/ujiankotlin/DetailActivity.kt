package com.bcaf.ujiankotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bcaf.ujiankotlin.model.Article


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val article = intent.getParcelableExtra<Article>("ARTICLE")

        if (article != null) {
            supportActionBar?.title = article.title
            findViewById<ImageView>(R.id.articleDetailImage).setImageResource(article.imageResourceId)
            findViewById<TextView>(R.id.articleDetailTitle).text = article.title
            findViewById<TextView>(R.id.articleDetailOverview).text = article.overview
            findViewById<TextView>(R.id.articleDetailDescription).text = article.description
        }

    }


}
