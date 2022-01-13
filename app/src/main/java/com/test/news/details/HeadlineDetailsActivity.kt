package com.test.news.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.test.news.R
import com.test.news.model.toHeadline
import kotlinx.android.synthetic.main.activity_headline_details.*

class HeadlineDetailsActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_headline_details)

    intent.extras?.let { extras ->
      val headline = extras.toHeadline()
      println("debug: $headline")

      Glide.with(this).load(headline.imageUrl).into(imageHeadline)

      labelHeadlineTitle.text = headline.title
      labelHeadlineSource.text = headline.source
      labelHeadlineDate.text = headline.date
      labelHeadlineDescription.text = headline.description
    }

    imageBack.setOnClickListener {
      finish()
    }
  }
}