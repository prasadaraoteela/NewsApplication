package com.test.news.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.test.news.databinding.ActivityHeadlineDetailsBinding
import com.test.news.model.toHeadline
import com.test.news.ui.viewBinding

class HeadlineDetailsActivity : AppCompatActivity() {

  private val binding: ActivityHeadlineDetailsBinding by viewBinding(ActivityHeadlineDetailsBinding::inflate)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    intent.extras?.let { extras ->
      val headline = extras.toHeadline()
      println("debug: $headline")

      Glide.with(this).load(headline.imageUrl).into(binding.imageHeadline)

      binding.labelHeadlineTitle.text = headline.title
      binding.labelHeadlineSource.text = headline.source
      binding.labelHeadlineDate.text = headline.date
      binding.labelHeadlineDescription.text = headline.description
    }

    binding.imageBack.setOnClickListener {
      finish()
    }
  }
}